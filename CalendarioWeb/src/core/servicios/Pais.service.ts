import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pais } from '../../shared/entidades/Pais';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class PaisService {
    private url: string;

    constructor(private http: HttpClient) {
    this.url = `${environment.urlBase}paises/`;
    }

    public listar(): Observable<Pais[]> {
    return this.http.get<Pais[]>(`${this.url}listar`);
    }
}
