const { createApp } = Vue

    createApp({
        mounted(){
            fetch("http://localhost:8080/pokemon/list").then(response => {
                return response.json()
            }).then(data => {
                this.pokemonList = data
                this.pokemonList = this.pokemonList.map(pokemon => {
                    pokemon.strId = pokemon.pokeId.toString().padStart(3, '0')
                    pokemon.gender = pokemon.gender == 'm' ? 'Macho' : 'Fêmea'
                    return pokemon
                })
                this.pokemonList.sort(function(a, b){
                    return a.strId < b.strId ? -1 : a.strId > b.strId ? 1 : 0;
                })
                console.log(this.pokemonList)
            })
        },

        data() {
            return {
                pokemonList: []
            }
            
        },

        methods: {
            deletePokemon(id){
                fetch('http://localhost:8080/pokemon/remove?id=' + id , {
                    method: 'DELETE',
                }).then(response => {
                    alert("Pokemon removido com sucesso!")
                    return response.text()
                }).then(data => {
                    window.location.reload()
                })
            }
        }
        
    }).mount('#app')