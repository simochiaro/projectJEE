package it.unifi.dinfo.stdlab.projectSpark;

import static spark.Spark.*;

import java.sql.Date;


import it.unifi.dinfo.stdlab.projectSpark.controller.ArbitroController;
import it.unifi.dinfo.stdlab.projectSpark.controller.DesignatoreController;
import it.unifi.dinfo.stdlab.projectSpark.model.Designazione;
import it.unifi.dinfo.stdlab.projectSpark.model.Partita;
import it.unifi.dinfo.stdlab.projectSpark.model.Referto;




public class Main {
    public static void main(String[] args) {
    	
    	port(8080);
    	
    	
    	
    	get("/arbitro/controllaDesignazione/:username",(request, response) ->{
  		  ArbitroController ca=new ArbitroController();
  		  Partita partita=ca.controllaDesignazione(request.params(":username"));
  		  return "Partita:"+partita.getCasa().getNome()+" vs "+ partita.getOspite().getNome();
  	  	  });
        
        put("/arbitro/accettaDesignazione/:username", (request, response) ->{
      	 
  		  ArbitroController ca=new ArbitroController();
  		  Designazione des=ca.accettaDesignazione(request.params(":username"));
  		  return "Partita ACCETTATA:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
  				      "\n DATA:"+des.getData();
  	  	  });
        put("/arbitro/rifiutaDesignazione/:username", (request, response)->{
      	 
  		  ArbitroController ca=new ArbitroController();
  		  Designazione des=ca.rifiutaDesignazione(request.params(":username"));
  		  return "Partita RIFIUTATA:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
  				      "\n DATA:"+des.getData();
  	  	  });
        put("/arbitro/creaReferto/:username/:esito/:amm/:esp", (request, response) ->{
      	
      	  ArbitroController ca=new ArbitroController();
  		  if (ca.creaReferto(request.params(":username"),request.params(":esito"),request.params(":amm"),request.params(":esp")))
  			  return "Referto Creato";
  		  else
  			  return "Errore";
  		   });
        get("/arbitro/ricercaReferto/:username/:casa/:ospite", (request, response) ->{
      	  
  		  ArbitroController ca=new ArbitroController();
  		  Referto ref=ca.ricercaReferto(request.params(":username"),request.params(":casa"),request.params(":ospite"));
  		  return "Referto:"+ref.getPartita().getCasa().getNome()+" vs "+ ref.getPartita().getOspite().getNome()+
  				  "\n Esito:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n Espulsioni:"+ref.getEsp()+"\nSupplemento:"+ref.getSupplemento();
  	  	  });
        put("/arbitro/generaSupplemento/:username/:casa/:ospite/:supplemento", (request, response) ->{
      	  
  		  ArbitroController ca=new ArbitroController();
  		  Referto ref=ca.ricercaReferto(request.params(":username"),request.params(":casa"),request.params(":ospite"));
  		  ca.generaSupplemento(ref,request.params(":supplemento"));
  		  return " SUPPLEMENTO GENERATO \nReferto:"+ref.getPartita().getCasa().getNome()+" vs "+ ref.getPartita().getOspite().getNome()+
  				  "\n Esito:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n Espulsioni:"+ref.getEsp()+"\nSupplemento:"+request.params(":supplemento");
  	  	  });
        
        put("/designatore/generaDesignazione/:username/:arbitro/:data", (request, response) ->{
      	  
  		  DesignatoreController dC=new DesignatoreController();
  		  Date date=Date.valueOf(request.params(":data"));
  		  Designazione des=dC.generaDesignazione(request.params(":username"),request.params(":arbitro"),date);
  		  return " Designazione GENERATA \n Parita:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
  					  "\n Data:"+des.getData();
  	  	  });
        
        get("/designatore/controllaRifiuti/:username", (request, response) ->{
      	 
  		  DesignatoreController dC=new DesignatoreController();
  		  Boolean x=dC.controllaRifiuti(request.params(":username"));
          if(x)
  			 return " Ci sono RIFIUTI";
  		  else
  			 return " NON Ci sono RIFIUTI";
  	  	  });
        put("/designatore/designaRifiuto/:username/:arbitro", (request, response) ->{
      	  
  		  DesignatoreController dC=new DesignatoreController();
  		  Boolean x=dC.controllaRifiuti(request.params(":username"));
        	  if(x) {
        		  dC.designaRifiuto(request.params(":username"),request.params(":arbitro"));
  			  return " Partita Ri-Designata";}
  		  else
  			  return " NON Ci sono RIFIUTI";
  	  	  });
    }
}