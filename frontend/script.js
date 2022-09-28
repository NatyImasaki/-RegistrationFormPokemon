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
                this.typeList = data
            })
        },

        data() {
            return {
                pokeName: '',
                pokeList: [],
                suggestionList: [],
                typeList: []
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
            }   
        }

    }).mount('#app')