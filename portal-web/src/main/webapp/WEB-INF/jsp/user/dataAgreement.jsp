<%@ include file="/common/taglibs.jsp"%>
<div id="twopartheader">
	<h2><spring:message code="dataagreement.title" text="Data Use Agreement"/></h2>
</div>

<h4>Background</h4>
<p>The goals and principles of making biodiversity data openly and universally available have been defined in the Memorandum of Understanding on GBIF, paragraph 8 (see the relevant excerpts in the attached Annex).</p>

<p>The Participants who have signed the MoU have expressed their willingness to make biodiversity data available through their nodes to foster scientific research development internationally and to support the public use of these data.</p>

<p>GBIF data sharing should take place within a framework of due attribution.</p>

<p>Therefore, using data available through the GBIF network requires agreeing with the following:</p>

<h4>1. Data Use Agreements</h4>
<ol>
   <li>The quality and completeness of data cannot be guaranteed. Users employ these data at their own risk.</li>
   <li>Users shall respect restrictions of access to sensitive data.</li>
   <li>In order to make attribution of use for owners of the data possible, the identifier of ownership of data must be retained with every data record.</li>
   <li>Users must publicly acknowledge, in conjunction with the use of the data, the data publishers whose biodiversity data they have used.  Data publishers may require additional attribution of specific collections within their institution.</li>
   <li>Users must comply with additional terms and conditions of use set by the data publisher. Where these exist they will be available through the metadata associated with the data.</li>
</ol>

<h4>2. Citing Data</h4>
<p>Use the following format to cite data retrieved from the GBIF network:</p>  
<p><em>Biodiversity occurrence data published by: (Accessed through GBIF Data Portal, data.gbif.org, YYYY-MM-DD)</em></p>
<p>For example:</p>
<p><em>Biodiversity occurrence data published by: Field Museum of Natural History, Museum of Vertebrate Zoology, University of Washington Burke Museum, and University of Turku (Accessed through GBIF Data Portal, data.gbif.org, 2007-02-22)</em></p>

<h4>3. Definitions</h4>
<ul>
   <li>GBIF Participant: Signatory of the GBIF-establishing Memorandum of Understanding (MoU).</li>
   <li>GBIF Secretariat: Legal entity empowered by the GBIF Participants to enter into contracts, execute the Work Programme, and maintain the central services for the GBIF network.</li>
   <li>GBIF network: The infrastructure consisting of the central services of the GBIF Secretariat, Participant Nodes and data publishers. Making data available through GBIF network means registering and advertising the pertinent services via the GBIF central services.</li>
   <li>Node: A data publisher designated by a GBIF Participant that maintains a stable computer gateway that makes data available through the GBIF network.</li>
   <li>Participant node: An organisational unit designated by the GBIF Participant to coordinate activities in its domain. It may also provide data.</li>
   <li>Biodiversity data:  Primary data on specimens, observations, names, taxonomic concepts, and sites, and other related data on biological diversity.</li>
   <li>Metadata: Data describing the attributes and combinations of biodiversity data.</li>
   <li>Data:  Biodiversity data and metadata.</li>
   <li>Data publisher: A custodian of data making it technically available. This may or may not be the data owner. If not they will have declared to GBIF that they have permission to make the data available.</li>
   <li>Data sharing: The process of and agreements for making data freely and universally available on the Internet.</li>
   <li>User:  Anyone who uses the Internet to access data through the GBIF network.</li>
   <li>Owner of data: The legal entity possessing the right resulting from the act of creating a digital record. The record may be a product derived from another, possibly non-digital product, which may affect the right.</li>
   <li>Sensitive data: Any data that the Node does not want to make available,  e.g. precise localities of endangered species.</li>
</ul><br/>

<p>Also see the <a href="${pageContext.request.contextPath}/tutorial/datasharingagreement">GBIF Data Sharing Agreement</a> for the data publishers.</p>

<form method="post" action="terms.htm" form="acceptForm" class="acceptForm">
  <input type="hidden" name="forwardUrl" value="${param['forwardUrl']}"/>
  <input type="submit" name="acceptedTerms" value="<spring:message code="dataagreement.accept"/>"/>
  <input type="submit" name="refuseTerms" value="<spring:message code="dataagreement.cancel"/>"/>
</form>

<p><spring:message code="dataagreement.cookie.warning" text="Depending on your browser settings, a cookie may be stored to acknowledge your acceptance of these terms."/></p>