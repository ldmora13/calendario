import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tipo } from '../../shared/entidades/Tipo';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class TipoService {
    private url: string;

    constructor(private http: HttpClient) {
    this.url = `${environment.urlBase}tipos/`;
    }

    public listar(): Observable<Tipo[]> {
    return this.http.get<Tipo[]>(`${this.url}listar`);
    }
}
