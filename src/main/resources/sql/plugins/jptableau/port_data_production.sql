INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jptableauTableau', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Publish Tableau</property>
<property key="it">Pubblica Tableau</property>
</properties>', '<config>
	<parameter name="id">id</parameter>
	<action name="jptableauTableauConfig"/>
</config>','jptableau', NULL, NULL, 1, 'free');

INSERT INTO widgetcatalog (code, titles, parameters, plugincode, parenttypecode, defaultconfig, locked, maingroup) VALUES ('jptableauTableau_list_form', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="en">Tableau List and Form</property>
<property key="it">Lista e Form Tableau</property>
</properties>', NULL, 'jptableau', 'formAction', '<?xml version="1.0" encoding="UTF-8"?>
<properties>
<property key="actionPath">/ExtStr2/do/FrontEnd/jptableau/Tableau/list.action</property>
</properties>', 1, 'free');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_ID', 'en', 'id');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_ID', 'it', 'id');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NAME', 'en', 'name');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NAME', 'it', 'name');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_SITEROLE', 'en', 'siterole');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_SITEROLE', 'it', 'siterole');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_AUTHSETTING', 'en', 'authsetting');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_AUTHSETTING', 'it', 'authsetting');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_LASTLOGIN', 'en', 'lastlogin');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_LASTLOGIN', 'it', 'lastlogin');


INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_ACTIONS', 'it', 'Actions');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_ACTIONS', 'en', 'Actions');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NEW', 'it', 'Tableau New');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NEW', 'en', 'Tableau New');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_EDIT', 'it', 'Tableau Edit');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_EDIT', 'en', 'Tableau Edit');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_TRASH', 'it', 'Tableau Trash');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_TRASH', 'en', 'Tableau Trash');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_TRASH_CONFIRM', 'it', 'Tableau Trash confirm');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_TRASH_CONFIRM', 'en', 'Tableau Trash confirm');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_SEARCH_TABLEAU', 'it', 'Tableau search');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_SEARCH_TABLEAU', 'en', 'Tableau search');

INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NOT_FOUND', 'it', 'Tableau not found');
INSERT INTO localstrings ( keycode, langcode, stringvalue ) VALUES ('jptableau_TABLEAU_NOT_FOUND', 'en', 'Tableau not found');


INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jptableau_is_front_Tableau_entry', 'jptableauTableau_list_form', 'jptableau', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsf=JspTaglibs["/apsadmin-form"]>

<@wp.info key="currentLang" var="currentLangVar" />

<#assign js_for_datepicker="jQuery(function($){
$.datepicker.regional[''it''] = {
closeText: ''Chiudi'',
prevText: ''&#x3c;Prec'',
nextText: ''Succ&#x3e;'',
currentText: ''Oggi'',
monthNames: [''Gennaio'',''Febbraio'',''Marzo'',''Aprile'',''Maggio'',''Giugno'',
''Luglio'',''Agosto'',''Settembre'',''Ottobre'',''Novembre'',''Dicembre''],
monthNamesShort:  [''Gen'',''Feb'',''Mar'',''Apr'',''Mag'',''Giu'',
''Lug'',''Ago'',''Set'',''Ott'',''Nov'',''Dic''],
dayNames: [''Domenica'',''Luned&#236'',''Marted&#236'',''Mercoled&#236'',''Gioved&#236'',''Venerd&#236'',''Sabato''],
dayNamesShort: [''Dom'',''Lun'',''Mar'',''Mer'',''Gio'',''Ven'',''Sab''],
dayNamesMin: [''Do'',''Lu'',''Ma'',''Me'',''Gi'',''Ve'',''Sa''],
weekHeader: ''Sm'',
dateFormat: ''dd/mm/yy'',
firstDay: 1,
isRTL: false,
showMonthAfterYear: false,
yearSuffix: ''''};
});

jQuery(function($) {
 if (Modernizr.touch && Modernizr.inputtypes.date) {
  $.each( $(\"input[data-isdate=true]\"), function(index, item) {
   item.type = ''date'';
  });
 } else {
  $.datepicker.setDefaults( $.datepicker.regional[ \"${currentLangVar}\" ] );
  $(\"input[data-isdate=true]\").datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: \"dd/mm/yy\"
   });
 }
});
">
<@wp.headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<@wp.headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<@wp.headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<@wp.headInfo type="JS_RAW" info="${js_for_datepicker}" />
<section>
<@s.if test="strutsAction==1">
	<h1><@wp.i18n key="jptableau_TABLEAU_NEW" /></h1>
</@s.if>
<@s.elseif test="strutsAction==2">
	<h1><@wp.i18n key="jptableau_TABLEAU_EDIT" /></h1>
</@s.elseif>
<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/save.action" />" method="post">
	<@s.if test="hasFieldErrors()">
		<div class="alert alert-error">
			<h2><@s.text name="message.title.FieldErrors" /></h2>
			<ul>
				<@s.iterator value="fieldErrors">
					<@s.iterator value="value">
				<li><@s.property/></li>
					</@s.iterator>
				</@s.iterator>
			</ul>
		</div>
	</@s.if>
	<@s.if test="hasActionErrors()">
		<div class="alert alert-error">
			<h2><@s.text name="message.title.ActionErrors" /></h2>
			<ul>
				<@s.iterator value="actionErrors">
				<li><@s.property/></li>
				</@s.iterator>
			</ul>
		</div>
	</@s.if>
	<p class="sr-only">
		<@wpsf.hidden name="strutsAction" />
		<@wpsf.hidden name="id" />
	</p>
	<fieldset>
		<label for="tableau_name"><@wp.i18n key="jptableau_TABLEAU_NAME" /></label>
		<input type="text" name="name" id="tableau_name" value="<@s.property value="name" />" />
		<label for="tableau_siterole"><@wp.i18n key="jptableau_TABLEAU_SITEROLE" /></label>
		<input type="text" name="siterole" id="tableau_siterole" value="<@s.property value="siterole" />" />
		<label for="tableau_authsetting"><@wp.i18n key="jptableau_TABLEAU_AUTHSETTING" /></label>
		<input type="text" name="authsetting" id="tableau_authsetting" value="<@s.property value="authsetting" />" />
		<label for="tableau_lastlogin"><@wp.i18n key="jptableau_TABLEAU_LASTLOGIN" /></label>
		<input type="text" name="lastlogin" id="tableau_lastlogin" value="<@s.property value="lastlogin" />" />
	</fieldset>
	<@wpsf.submit type="button" cssClass="btn btn-primary">
		<@wp.i18n key="SAVE" />
	</@wpsf.submit>
</form>
</section>', 1);
INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jptableau_is_front_Tableau_error', 'jptableauTableau_list_form', 'jptableau', NULL, '<pre>
   __   _ __   _ __   ___   _ __  
 /''__`\/\`''__\/\`''__\/ __`\/\`''__\
/\  __/\ \ \/ \ \ \//\ \L\ \ \ \/ 
\ \____\\ \_\  \ \_\\ \____/\ \_\ 
 \/____/ \/_/   \/_/ \/___/  \/_/ 
                                  
</pre>', 1);




INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jptableau_is_front_Tableau_list', 'jptableauTableau_list_form', 'jptableau', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsa=JspTaglibs["/apsadmin-core"]>

<@wp.info key="currentLang" var="currentLangVar" />

<#assign js_for_datepicker="jQuery(function($){
$.datepicker.regional[''it''] = {
closeText: ''Chiudi'',
prevText: ''&#x3c;Prec'',
nextText: ''Succ&#x3e;'',
currentText: ''Oggi'',
monthNames: [''Gennaio'',''Febbraio'',''Marzo'',''Aprile'',''Maggio'',''Giugno'',
''Luglio'',''Agosto'',''Settembre'',''Ottobre'',''Novembre'',''Dicembre''],
monthNamesShort:  [''Gen'',''Feb'',''Mar'',''Apr'',''Mag'',''Giu'',
''Lug'',''Ago'',''Set'',''Ott'',''Nov'',''Dic''],
dayNames: [''Domenica'',''Luned&#236'',''Marted&#236'',''Mercoled&#236'',''Gioved&#236'',''Venerd&#236'',''Sabato''],
dayNamesShort: [''Dom'',''Lun'',''Mar'',''Mer'',''Gio'',''Ven'',''Sab''],
dayNamesMin: [''Do'',''Lu'',''Ma'',''Me'',''Gi'',''Ve'',''Sa''],
weekHeader: ''Sm'',
dateFormat: ''dd/mm/yy'',
firstDay: 1,
isRTL: false,
showMonthAfterYear: false,
yearSuffix: ''''};
});

jQuery(function($) {
 if (Modernizr.touch && Modernizr.inputtypes.date) {
  $.each( $(\"input[data-isdate=true]\"), function(index, item) {
   item.type = ''date'';
  });
 } else {
  $.datepicker.setDefaults( $.datepicker.regional[ \"${currentLangVar}\" ] );
  $(\"input[data-isdate=true]\").datepicker({
	changeMonth: true,
	changeYear: true,
	dateFormat: \"dd/mm/yy\"
   });
 }
});
">
<@wp.headInfo type="JS" info="entando-misc-html5-essentials/modernizr-2.5.3-full.js" />
<@wp.headInfo type="JS_EXT" info="http://code.jquery.com/ui/1.10.1/jquery-ui.js" />
<@wp.headInfo type="CSS_EXT" info="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<@wp.headInfo type="JS_RAW" info="${js_for_datepicker}" />

<section class="tableau_list">

<h1><@wp.i18n key="jptableau_TABLEAU_SEARCH_TABLEAU" /></h1>

<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/search.action" />" method="post" >

  <fieldset>
		<label for="tableau_id"><@wp.i18n key="jptableau_TABLEAU_ID" /></label>
		<input type="text" name="id" id="tableau_id" value="<@s.property value="id" />" />
		<label for="tableau_name"><@wp.i18n key="jptableau_TABLEAU_NAME" /></label>
		<input type="text" name="name" id="tableau_name" value="<@s.property value="name" />" />
		<label for="tableau_siterole"><@wp.i18n key="jptableau_TABLEAU_SITEROLE" /></label>
		<input type="text" name="siterole" id="tableau_siterole" value="<@s.property value="siterole" />" />
		<label for="tableau_authsetting"><@wp.i18n key="jptableau_TABLEAU_AUTHSETTING" /></label>
		<input type="text" name="authsetting" id="tableau_authsetting" value="<@s.property value="authsetting" />" />
		<label for="tableau_lastlogin"><@wp.i18n key="jptableau_TABLEAU_LASTLOGIN" /></label>
		<input type="text" name="lastlogin" id="tableau_lastlogin" value="<@s.property value="lastlogin" />" />
  </fieldset>

  <button type="submit" class="btn btn-primary">
    <@wp.i18n key="SEARCH" />
  </button>

<@wpsa.subset source="tableausId" count=10 objectName="groupTableau" advanced=true offset=5>
<@s.set name="group" value="#groupTableau" />
<@wp.freemarkerTemplateParameter var="group" valueName="groupTableau" removeOnEndTag=true >
<div class="margin-medium-vertical text-center">
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pagerInfo.jsp" />
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
	<#--
	<@wp.fragment code="default_pagerInfo_is" escapeXml=false />
	<@wp.fragment code="default_pagerFormBlock_is" escapeXml=false />
	-->
</div>
<p>
  <a href="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/new.action"></@wp.action>" title="<@wp.i18n key="NEW" />" class="btn btn-info">
    <span class="icon-plus-sign icon-white"></span>&#32;
    <@wp.i18n key="NEW" />
  </a>
</p>
<table class="table table-bordered table-condensed table-striped">
<thead>
<tr>
  <th class="text-right">
    <@wp.i18n key="jptableau_TABLEAU_ID" />
  </th>
	<th
                 class="text-left"><@wp.i18n key="jptableau_TABLEAU_NAME" /></th>
	<th
                 class="text-left"><@wp.i18n key="jptableau_TABLEAU_SITEROLE" /></th>
	<th
                 class="text-left"><@wp.i18n key="jptableau_TABLEAU_AUTHSETTING" /></th>
	<th
                 class="text-left"><@wp.i18n key="jptableau_TABLEAU_LASTLOGIN" /></th>
	<th>
    <@wp.i18n key="jptableau_TABLEAU_ACTIONS" />
  </th>
</tr>
</thead>
<tbody>
<@s.iterator var="tableauId">
<tr>
	<@s.set var="tableau" value="%{getTableau(#tableauId)}" />
	<td class="text-right">
    <a
      href="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/edit.action"><@wp.parameter name="id"><@s.property value="#tableau.id" /></@wp.parameter></@wp.action>"
      title="<@wp.i18n key="EDIT" />: <@s.property value="#tableau.id" />"
      class="label label-info display-block">
    <@s.property value="#tableau.id" />&#32;
    <span class="icon-edit icon-white"></span>
    </a>
  </td>
	<td
            >
    <@s.property value="#tableau.name" />  </td>
	<td
            >
    <@s.property value="#tableau.siterole" />  </td>
	<td
            >
    <@s.property value="#tableau.authsetting" />  </td>
	<td
            >
    <@s.property value="#tableau.lastlogin" />  </td>
	<td class="text-center">
    <a
      href="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/trash.action"><@wp.parameter name="id"><@s.property value="#tableau.id" /></@wp.parameter></@wp.action>"
      title="<@wp.i18n key="TRASH" />: <@s.property value="#tableau.id" />"
      class="btn btn-warning btn-small">
      <span class="icon-trash icon-white"></span>&#32;
      <@wp.i18n key="TRASH" />
    </a>
  </td>
</tr>
</@s.iterator>
</tbody>
</table>
<div class="margin-medium-vertical text-center">
	<@s.include value="/WEB-INF/apsadmin/jsp/common/inc/pager_formBlock.jsp" />
	<#--
	<@wp.fragment code="default_pagerFormBlock_is" escapeXml=false />
	-->
</div>
</@wp.freemarkerTemplateParameter>
</@wpsa.subset>
</form>
</section>', 1);

INSERT INTO guifragment (code, widgettypecode, plugincode, gui, defaultgui, locked) VALUES ('jptableau_is_front_Tableau_trash', 'jptableauTableau_list_form', 'jptableau', NULL, '<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["/struts-tags"]>
<#assign wp=JspTaglibs["/aps-core"]>
<#assign wpsf=JspTaglibs["/apsadmin-form"]>

<section>
	<h1><wp:i18n key="jptableau_TABLEAU_TRASH" /></h1>
	<form action="<@wp.action path="/ExtStr2/do/FrontEnd/jptableau/Tableau/delete.action" />" method="post">
		<@s.if test="hasFieldErrors()">
			<div class="alert alert-error">
				<h2><@s.text name="message.title.FieldErrors" /></h2>
				<ul>
					<@s.iterator value="fieldErrors">
						<@s.iterator value="value">
						<li><@s.property /></li>
						</@s.iterator>
					</@s.iterator>
				</ul>
			</div>
		</@s.if>
		<@s.if test="hasActionErrors()">
			<div class="alert alert-error">
				<h2><@s.text name="message.title.ActionErrors" /></h2>
				<ul>
					<@s.iterator value="actionErrors">
					<li><@s.property /></li>
					</@s.iterator>
				</ul>
			</div>
		</@s.if>
		<p class="sr-only">
			<@wpsf.hidden name="strutsAction" />
			<@wpsf.hidden name="id" />
		</p>
		<div class="alert alert-warning">
			<p>
				<@wp.i18n key="jptableau_TABLEAU_TRASH_CONFIRM" />&#32;<@wp.i18n key="jptableau_TABLEAU_ID" />&#32;<@s.property value="id" />?
			</p>
			<p>
				<@wpsf.submit type="button" cssClass="btn btn-warning">
					<span class="icon-trash icon-white"></span>&#32;
					<@wp.i18n key="TRASH" />
				</@wpsf.submit>
			</p>
		</div>
	</form>
</section>', 1);

