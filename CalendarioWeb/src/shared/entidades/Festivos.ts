import { Tipo } from "./Tipo";
import { Pais } from "./Pais";

export interface Festivos {
    id: number;
    nombre: string;
    dia: number;
    mes: number;
    diasPascua: number;
    tipo: Tipo;
    pais: Pais;
}