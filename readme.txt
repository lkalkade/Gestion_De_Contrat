Gestion des stagiaires v2-------------------------
Url     : http://codes-sources.commentcamarche.net/source/101324-gestion-des-stagiaires-v2Auteur  : tlili_soufDate    : 02/01/2016
Licence :
=========

Ce document intitulé « Gestion des stagiaires v2 » issu de CommentCaMarche
(codes-sources.commentcamarche.net) est mis à disposition sous les termes de
la licence Creative Commons. Vous pouvez copier, modifier des copies de cette
source, dans les conditions fixées par la licence, tant que cette note
apparaît clairement.

Description :
=============

Il s'agit de la deuxiÃ¨me version .Les interfaces sont presque les mÃªmes,en fai
te je ne concentre pas sur l'IHM (view) mais plutÃ´t sur le mÃ©tier(business log
ic),je recours aux designs patterns comme MVC,DAO,POJO,Observer, Singleton.
<br
 />
<br />package com.app.main;
<br />import javax.swing.SwingUtilities;
<br 
/>import com.app.controller.Controller;
<br />public class Main {
<br /> publi
c static void main(String[] args) {
<br />  SwingUtilities.invokeLater(new Runn
able() {
<br />   @Override
<br />   public void run() {
<br />    new Contro
ller();
<br />   }
<br />  });
<br /> }
<br />}
