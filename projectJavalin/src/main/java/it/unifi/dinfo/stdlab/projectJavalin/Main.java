package it.unifi.dinfo.stdlab.projectJavalin;



import java.sql.Date;

import io.javalin.Javalin;
import it.unifi.dinfo.stdlab.projectJavalin.controller.ArbitroController;
import it.unifi.dinfo.stdlab.projectJavalin.controller.DesignatoreController;
import it.unifi.dinfo.stdlab.projectJavalin.model.Designazione;
import it.unifi.dinfo.stdlab.projectJavalin.model.Partita;
import it.unifi.dinfo.stdlab.projectJavalin.model.Referto;



public class Main {

  public static void main(String[] args) {
	  
	  
	  
	  
	  Javalin app = Javalin.create().start(8080);
	  
      app.get("/arbitro/controllaDesignazione", ctx ->{
    	  String username=ctx.queryParam("username");
		  ArbitroController ca=new ArbitroController();
		  Partita partita=ca.controllaDesignazione(username);
		  ctx.result("Partita:"+partita.getCasa().getNome()+" vs "+ partita.getOspite().getNome());
	  	  });
      
      app.put("/arbitro/accettaDesignazione", ctx ->{
    	  String username=ctx.queryParam("username");
		  ArbitroController ca=new ArbitroController();
		  Designazione des=ca.accettaDesignazione(username);
		  ctx.result("Partita ACCETTATA:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
				      "\n DATA:"+des.getData());
	  	  });
      app.put("/arbitro/rifiutaDesignazione", ctx ->{
    	  String username=ctx.queryParam("username");
		  ArbitroController ca=new ArbitroController();
		  Designazione des=ca.rifiutaDesignazione(username);
		  ctx.result("Partita RIFIUTATA:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
				      "\n DATA:"+des.getData());
	  	  });
      app.put("/arbitro/creaReferto", ctx ->{
    	  String username=ctx.queryParam("username");
    	  String esito=ctx.queryParam("esito");
    	  String amm=ctx.queryParam("amm");
    	  String esp=ctx.queryParam("esp");
    	  
		  ArbitroController ca=new ArbitroController();
		  if (ca.creaReferto(username,esito,amm,esp))
			  ctx.result("Referto Creato");
		  else
			  ctx.result("Errore");
		   });
      app.get("/arbitro/ricercaReferto", ctx ->{
    	  String username=ctx.queryParam("username");
    	  String casa=ctx.queryParam("casa");
    	  String ospite=ctx.queryParam("ospite");
		  ArbitroController ca=new ArbitroController();
		  Referto ref=ca.ricercaReferto(username,casa,ospite);
		  ctx.result("Referto:"+ref.getPartita().getCasa().getNome()+" vs "+ ref.getPartita().getOspite().getNome()+
				  "\n Esito:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n Espulsioni:"+ref.getEsp()+"\nSupplemento:"+ref.getSupplemento());
	  	  });
      app.put("/arbitro/generaSupplemento", ctx ->{
    	  String username=ctx.queryParam("username");
    	  String casa=ctx.queryParam("casa");
    	  String ospite=ctx.queryParam("ospite");
    	  String supplemento=ctx.queryParam("supplemento");
		  ArbitroController ca=new ArbitroController();
		  Referto ref=ca.ricercaReferto(username,casa,ospite);
		  ca.generaSupplemento(ref,supplemento);
		  ctx.result(" SUPPLEMENTO GENERATO \nReferto:"+ref.getPartita().getCasa().getNome()+" vs "+ ref.getPartita().getOspite().getNome()+
				  "\n Esito:"+ref.getEsito()+"\n Ammonizioni:"+ref.getAmm()+"\n Espulsioni:"+ref.getEsp()+"\nSupplemento:"+supplemento);
	  	  });
      
      app.put("/designatore/generaDesignazione", ctx ->{
    	  String username=ctx.queryParam("username");
    	  String arbitro=ctx.queryParam("arbitro");
    	  String data=ctx.queryParam("data");
		  DesignatoreController dC=new DesignatoreController();
		  Date date=Date.valueOf(data);
		  Designazione des=dC.generaDesignazione(username,arbitro,date);
		  if (des!=null)
			  ctx.result(" Designazione GENERATA \n Parita:"+des.getPartita().getCasa().getNome()+" vs "+ des.getPartita().getOspite().getNome()+
					  "\n Data:"+des.getData());
	  	  });
      
      app.get("/designatore/controllaRifiuti", ctx ->{
    	  String username=ctx.queryParam("username");
		  DesignatoreController dC=new DesignatoreController();
		  Boolean x=dC.controllaRifiuti(username);
      	  if(x)
			  ctx.result(" Ci sono RIFIUTI");
		  else
			  ctx.result(" NON Ci sono RIFIUTI");
	  	  });
      app.put("/designatore/designaRifiuto", ctx ->{
    	  String username=ctx.queryParam("username");
    	  String arbitro=ctx.queryParam("arbitro");
		  DesignatoreController dC=new DesignatoreController();
		  Boolean x=dC.controllaRifiuti(username);
      	  if(x) {
      		  dC.designaRifiuto(username, arbitro);
			  ctx.result(" Partita Ri-Designata");}
		  else
			  ctx.result(" NON Ci sono RIFIUTI");
	  	  });
      
  }
}