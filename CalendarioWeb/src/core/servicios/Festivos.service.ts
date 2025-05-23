import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Festivos } from '../../shared/entidades/Festivos';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class FestivoService {
    private url: string;

    constructor(private http: HttpClient) {
    this.url = `${environment.urlBase}festivos/`;
    }

    public listar(): Observable<Festivos[]> {
    return this.http.get<Festivos[]>(`${this.url}listar`);
    }

    public buscar(id: number): Observable<Festivos> {
    return this.http.get<Festivos>(`${this.url}${id}`);
    }

    public agregar(festivo: Festivos): Observable<Festivos> {
    return this.http.post<Festivos>(`${this.url}agregar`, festivo);
    }

    public modificar(festivo: Festivos): Observable<Festivos> {
    return this.http.put<Festivos>(`${this.url}modificar`, festivo);
    }

    public eliminar(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.url}eliminar/${id}`);
    }
}
