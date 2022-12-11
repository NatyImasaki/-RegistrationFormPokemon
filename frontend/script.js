const { createApp } = Vue 
    
    createApp({
        
        mounted(){
            fetch("https://pokeapi.co/api/v2/pokemon/?limit=1154").then(response => {
                return response.json()
            }).then(data => {
                this.pokeList = data.results.map(p => p.name)
            })

            fetch("http://localhost:8080/type/list").then(response => {
                return response.json()
            }).then(data => {
                this.typeList = data;
                this.typeList = this.typeList.map(type => {
                    type.selected = false
                    return type
                })
            })
        },

        data() {
            return {
                pokeName: '',
                pokeList: [],
                suggestionList: [],
                typeList: [], 
                pokeNick: '',
                pokeLv: null,
                pokeGender: '',
                pokeNature: ''      
            }
        },

        methods: {
            onTypeName(event){
                if(this.pokeName.length > 3) {
                    this.suggestionList = this.pokeList.filter(name => {
                        return name.startsWith(this.pokeName.toLowerCase())
                    })
                }else {
                    this.suggestionList =[]
                }
                console.log(this.suggestionList)
            },

            setName(name){
                this.pokeName = name[0].toUpperCase() + name.slice(1)
                this.suggestionList = []
            },
            
            getInfo(){
                let obj = {
                    pokeId: null,
                    name: this.pokeName,
                    nick: this.pokeNick,
                    level: this.pokeLv,
                    gender: this.pokeGender,
                    nature: this.pokeNature,
                    types: this.typeList.filter(type => type.selected).map(type => {
                        delete type.selected
                        return type
                    })   
                }


                fetch("https://pokeapi.co/api/v2/pokemon/" + obj.name.toLowerCase() + "/").then(response => {
                    return response.json()
                }).then(data => {
                    obj.pokeId = data.id
                    

                    fetch("http://localhost:8080/pokemon/add",{
                        method: "POST",
                        body: JSON.stringify(obj),
                        headers:  new Headers({
                            "Content-Type": "application/json"
                        })
                    }).then(response => {
                        return response.text()
                    }).then(data => {
                        this.pokeName = ""
                        this.pokeNick = ""
                        this.pokeLv = ""
                        this.pokeGender = ""
                        this.pokeNature = ""
                    })
                })

                
                
            }
        }

    }).mount('#app')