function soma (num1: number, num2 :number) {
    return (num1 + num2);
}

console.log(soma(1,2));

//types
//interfaces

interface IAnimal{
    nome: string;
    tipo: 'terrestre' | 'aquático';
    domestico: boolean;
    

}

interface IFelino extends IAnimal{
    visaoNoturna: boolean;
}

interface ICanino extends IAnimal{
    porte: 'pequeno' | 'médio' | 'grande';
}

type IDomestico = IFelino | ICanino;


const animal: IAnimal = {
    nome: 'elefante',
    tipo: "terrestre",
    domestico: false,
}

const animal1: IDomestico = {
    domestico: true,
    nome: 'cachorro',
    porte: 'médio',
    tipo: 'terrestre',
}


//input

const input = document.getElementById('input') as HTMLInputElement;

input.addEventListener('input', (event =>{
    const i = event.currentTarget as HTMLInputElement;
    console.log(i.value);    
}))

//generic types

function adicionaApendiceALista<T>(array: T[], valor: T){
    return array.map(() => valor);
}

adicionaApendiceALista([1,2,3], 1);
adicionaApendiceALista(['A','B','C'], 'd');



//condicionais com parâmetros

interface IUsuario {
    id: string;
    email: string;
    cargo?: 'gerente' | 'coordenador' | 'supervisor' | 'funcionario';
}


function redirecione(usuario: IUsuario ){
    if(usuario.cargo)   {
        //redirecionar(usuario.cargo);
    }
    //redirecionar para área do usuário
}


//variáveis readonly e private

interface Cachorro{
    nome: string
    idade: number;
    parqueFavorito?: string;
}

type CachorroSomenteLeitura = {
    +readonly [K in keyof Cachorro]-? : Cachorro[K];
}

class MeuCachorro implements CachorroSomenteLeitura{
    nome;
    idade;
    parqueFavorito: string;
    
    constructor(nome: string, idade: number, parqueFavorito?:any){
        this.idade = idade;
        this.nome = nome;   
        this.parqueFavorito = parqueFavorito;            
    }    
    
}
const cao = new MeuCachorro('Apolo', 14);
cao.idade = 8;

console.log(cao);

//importar bibliotecas

interface Estudante {
    nome: string;
    idade: number;
}

interface Estudante{
    serie: string;
}


import $ from 'jquery';

$.fn.extend({
    novaFuncao(){
        console.log('Chamou nova funcao');
    }
})

$('body').novaFuncao();

// omit

interface Pessoa{
    nome: string;
    idade: number;
    nacionalidade: string;
}

interface Brasileiro extends Omit<Pessoa, 'nacionalidade'>{

}

const brasileiro: Brasileiro = {
    idade: 10,
    nome: 'juca'
}