<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"
	xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI"
	typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath"
	targetNamespace="http://www.activiti.org/test">
	<process id="newCampusSetup" name="Setup a brand new campus"
		isExecutable="true">
		<startEvent id="startevent1" name="Start"></startEvent>
		<endEvent id="endevent1" name="End"></endEvent>
		<userTask id="configureCampus" name="Provide new campus configuration"
			activiti:candidateGroups="campus">
			<documentation>Provide the configuration of the new campus
			</documentation>
			<extensionElements>
				<activiti:formProperty id="campusName" name="Campus Name"
					type="string"></activiti:formProperty>
				<activiti:formProperty id="campusID" name="CampusID"
					type="string"></activiti:formProperty>
				<activiti:formProperty id="campusType" type="enum">
					<activiti:value id="officialCampus" name="Official"></activiti:value>
					<activiti:value id="boltonCampus" name="Bolt-On"></activiti:value>
					<activiti:value id="offCampus" name="OffCampus"></activiti:value>
				</activiti:formProperty>
			</extensionElements>
		</userTask>
		<userTask id="configureNavFlyoutCampusStrings" name="Add the strings for the nav flyout content"
			activiti:candidateGroups="productManager">
			<documentation>Create the strings for the nav flyout.</documentation>
			<extensionElements>
				<activiti:formProperty id="nav-free-two-day"
					name="Nav Free Two Day String" type="string"></activiti:formProperty>
				<activiti:formProperty id="nav-when-you-join"
					name="Nav When You Join String" type="string"></activiti:formProperty>
				<activiti:formProperty id="nav-when-you-join"
					name="NavLearn More Button String" type="string"></activiti:formProperty>
			</extensionElements>
		</userTask>
		<userTask id="configureNavFlyoutCampusImage" name="Add the image for the nav flyout content"
			activiti:candidateGroups="productManager">
			<documentation>Configure the image for the nav flyout.
			</documentation>
			<extensionElements>
				<activiti:formProperty id="navImage" name="Nav Image"
					type="string"></activiti:formProperty>
			</extensionElements>
		</userTask>
		<sequenceFlow id="flow2" sourceRef="startevent1"
			targetRef="configureCampus"></sequenceFlow>
		<sequenceFlow id="flow5" sourceRef="configureNavFlyoutCampusStrings"
			targetRef="configureNavFlyoutCampusImage"></sequenceFlow>
		<sequenceFlow id="flow6" sourceRef="configureNavFlyoutCampusImage"
			targetRef="endevent1"></sequenceFlow>
		<sequenceFlow id="flow7" sourceRef="configureCampus"
			targetRef="mailtask1"></sequenceFlow>
		<serviceTask id="mailtask1" name="Mail Task"
			activiti:type="mail">
			<extensionElements>
				<activiti:field name="to">
					<activiti:string><![CDATA[ayush.nitit.30@gmail.com]]></activiti:string>
				</activiti:field>
				<activiti:field name="from">
					<activiti:string><![CDATA[ayush.nitit.30@gmail.com]]></activiti:string>
				</activiti:field>
				<activiti:field name="subject">
					<activiti:string><![CDATA[XYZ]]></activiti:string>
				</activiti:field>
				<activiti:field name="html">
					<activiti:string><![CDATA[Hi,

Please configure the image and the string for the NAV flyout

Thanks,
Campus Team]]></activiti:string>
				</activiti:field>
			</extensionElements>
		</serviceTask>
		<sequenceFlow id="flow8" sourceRef="mailtask1"
			targetRef="configureNavFlyoutCampusStrings"></sequenceFlow>
	</process>
	<bpmndi:BPMNDiagram id="BPMNDiagram_newCampusSetup">
		<bpmndi:BPMNPlane bpmnElement="newCampusSetup"
			id="BPMNPlane_newCampusSetup">
			<bpmndi:BPMNShape bpmnElement="startevent1"
				id="BPMNShape_startevent1">
				<omgdc:Bounds height="35.0" width="35.0" x="155.0" y="50.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNShape bpmnElement="endevent1" id="BPMNShape_endevent1">
				<omgdc:Bounds height="35.0" width="35.0" x="735.0" y="40.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNShape bpmnElement="configureCampus"
				id="BPMNShape_configureCampus">
				<omgdc:Bounds height="55.0" width="105.0" x="120.0" y="170.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNShape bpmnElement="configureNavFlyoutCampusStrings"
				id="BPMNShape_configureNavFlyoutCampusStrings">
				<omgdc:Bounds height="55.0" width="105.0" x="500.0" y="170.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNShape bpmnElement="configureNavFlyoutCampusImage"
				id="BPMNShape_configureNavFlyoutCampusImage">
				<omgdc:Bounds height="55.0" width="105.0" x="700.0" y="170.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNShape bpmnElement="mailtask1" id="BPMNShape_mailtask1">
				<omgdc:Bounds height="55.0" width="105.0" x="270.0" y="170.0"></omgdc:Bounds>
			</bpmndi:BPMNShape>
			<bpmndi:BPMNEdge bpmnElement="flow2" id="BPMNEdge_flow2">
				<omgdi:waypoint x="172.0" y="85.0"></omgdi:waypoint>
				<omgdi:waypoint x="172.0" y="170.0"></omgdi:waypoint>
			</bpmndi:BPMNEdge>
			<bpmndi:BPMNEdge bpmnElement="flow5" id="BPMNEdge_flow5">
				<omgdi:waypoint x="605.0" y="197.0"></omgdi:waypoint>
				<omgdi:waypoint x="700.0" y="197.0"></omgdi:waypoint>
			</bpmndi:BPMNEdge>
			<bpmndi:BPMNEdge bpmnElement="flow6" id="BPMNEdge_flow6">
				<omgdi:waypoint x="752.0" y="170.0"></omgdi:waypoint>
				<omgdi:waypoint x="752.0" y="75.0"></omgdi:waypoint>
			</bpmndi:BPMNEdge>
			<bpmndi:BPMNEdge bpmnElement="flow7" id="BPMNEdge_flow7">
				<omgdi:waypoint x="225.0" y="197.0"></omgdi:waypoint>
				<omgdi:waypoint x="270.0" y="197.0"></omgdi:waypoint>
			</bpmndi:BPMNEdge>
			<bpmndi:BPMNEdge bpmnElement="flow8" id="BPMNEdge_flow8">
				<omgdi:waypoint x="375.0" y="197.0"></omgdi:waypoint>
				<omgdi:waypoint x="500.0" y="197.0"></omgdi:waypoint>
			</bpmndi:BPMNEdge>
		</bpmndi:BPMNPlane>
	</bpmndi:BPMNDiagram>
</definitions>
