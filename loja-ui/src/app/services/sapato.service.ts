import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, throwError } from "rxjs";
import { Sapato } from '../models/sapato.model';


@Injectable({ providedIn: "root" })
export class SapatoService {
    private PATH = 'http://localhost:8080/api/sapato'

    constructor(private http: HttpClient) { }

    getSapatos(): Observable<Sapato[]> {
        return this.http.get<Sapato[]>(`${this.PATH}/listar`).pipe(
            catchError(error => {
                console.error('Erro ao obter sapatos:', error);
                return throwError('Ocorreu um erro ao obter os sapatos. Por favor, tente novamente mais tarde.');
            })
        );
    }

}