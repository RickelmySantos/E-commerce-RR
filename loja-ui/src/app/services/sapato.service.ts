import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, map, shareReplay, throwError } from "rxjs";
import { Sapato } from '../models/sapato.model';


@Injectable({ providedIn: "root" })
export class SapatoService {
    private PATH = 'http://localhost:8080/api/sapato'

    constructor(private http: HttpClient) { }

    listarAllSapatos(): Observable<Sapato[]> {
        return this.http.get<Sapato[]>(`${this.PATH}/page`).pipe(map(sapato => sapato.map(sapato => ({ ...sapato, imagem: this.conversorBase64(sapato.imagem) }))), shareReplay(1),
            catchError(error => {
                console.error('Erro ao obter produtos:', error);
                return throwError('Ocorreu um erro ao obter os produtos. Por favor, tente novamente mais tarde.');
            })
        );
    }

    private conversorBase64(base64Data: string): string {
        return 'data:image/jpeg;base64,' + base64Data;
    }

}