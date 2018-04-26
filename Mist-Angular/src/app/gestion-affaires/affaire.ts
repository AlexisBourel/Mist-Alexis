export class Affaire {

    id: number;
    idAgent: number;
    titre: '';
    dateOuverture: '';
    status: '';
    dateCloture: '';
  

    constructor(idAgent,
                titre,
                dateOuverture,
                status,
                dateCloture) {
                    this.idAgent = idAgent;
                    this.titre = titre;
                    this.dateOuverture = dateOuverture;
                    this.status = status;
                    this.dateCloture = dateCloture;
                    
        }
}