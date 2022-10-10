const { createApp } = Vue

    createApp({
        mounted(){
            fetch("http://localhost:8080/pokemon/list").then(response => {
                return response.json()
            }).then(data => {
                this.pokemonList = data
                this.pokemonList = this.pokemonList.map(pokemon => {
                    pokemon.strId = pokemon.id.toString().padStart(3, '0')
                    pokemon.gender = pokemon.gender == 'm' ? 'Macho' : 'Fêmea'
                    return pokemon
                })
                console.log(this.pokemonList)
            })
        },

        data() {
            return {
                pokemonList: []
            }
            
        }
        
    }).mount('#app')