
	<#include "topHeader.ftl">	
		<div id="menulink" class="main_nav">
			<#list modules?keys as key>
			<ul>
				<#if key == "100">
					<li class="selected">
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>                   		 			
                   		 				<#if k == "101">
                   		 					<li><a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>                   		 								
                   		 									<#if k1 == "1011">
                   		 										<li><a href="showUserPage.do">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1012">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1013">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 	
                   		 							</#list>
                   		 						</ul>
                   		 					</li>				                		 		
                   		 				</#if>
                   		 				<#if k == "102">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "103">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "104">
                   		 					<li><a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>                   		 								
                   		 									<#if k1 == "1040">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1041">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1042">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1043">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 	
                   		 							</#list>
                   		 						</ul>
                   		 					</li>
                   		 				</#if>
                   		 				<#if k == "105">
                   		 					<li><a href="mch.do">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "106">
                   		 					<li><a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>                   		 								
                   		 									<#if k1 == "1060">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1061">
                   		 										<li><a href="showCampaignPage.do">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1062">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1063">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1064">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1065">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1066">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1067">
                   		 										<li><a href="#">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1068">
                   		 										<li><a href="showCalendarPage.do">${modules[k1]}</a></li>
                   		 									<#elseif k1 == "1069">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 	
                   		 							</#list>
                   		 						</ul>
                   		 					</li>
                   		 				</#if>
                   		 				<#if k == "107">
                   		 					<li><a href="show_lead_time.do">${modules[k]}</a></li>
                   		 				</#if>		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				<#if key == "200">
					<li>
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>
                   		 			<li>
                   		 				<#if k == "201">
                   		 					<a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>
                   		 								
                   		 									<#if k1 == "2011">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "2012">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>              		 									
                   		 								                  		 	
                   		 							</#list>
                   		 						</ul>				                		 		
                   		 				</#if>
                   		 				<#if k == "202">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "203">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "204">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>                   		 			        		 					
                   		 			</li>                   		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				
				<!-- promotion management -->
				
				<#if key == "300">
					<li >
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>
                   		 			<li>
                   		 				<#if k == "301">
                   		 					<a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>
                   		 								
                   		 									<#if k1 == "3010">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "3011">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "3012">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "3018">
                   		 										<li><a href="#">${modules[k1]}</a></li>                   		 									                   		 						                		 		
                   		 									</#if>                   		 									
                   		 								                		 	
                   		 							</#list>
                   		 						</ul>				                		 		
                   		 				</#if>
                   		 				<#if k == "302">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "303">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "304">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>                   		 			        		 					
                   		 			</li>                   		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				<#if key == "400">
					<li >
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>                   		 		
                   		 				<#if k == "401">
                   		 					<li><a href="#">${modules[k]}</a></li>                   		 										                		 		
                   		 				</#if>
                   		 				<#if k == "402">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "403">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>
                   		 				<#if k == "404">
                   		 					<li><a href="#">${modules[k]}</a></li>
                   		 				</#if>         		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				<#if key == "500">
					<li >
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>
                   		 			<li>
                   		 				<#if k == "501">
                   		 					<a href="#">${modules[k]}</a>
                   		 						<ul>  
                   		 							<#list modules?keys as k1>
                   		 								<li>
                   		 									<#if k1 == "5010">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "5011">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if> 
                   		 									<#if k1 == "5012">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 									
                   		 								</li>                   		 	
                   		 							</#list>
                   		 						</ul>				                		 		
                   		 				</#if>
                   		 				<#if k == "502">
                   		 					<a href="#">${modules[k]}</a>
                   		 					<ul>  
                   		 							<#list modules?keys as k1>
                   		 								<li>
                   		 									<#if k1 == "5020">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if>
                   		 									<#if k1 == "5021">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if> 
                   		 									<#if k1 == "5022">
                   		 										<a href="#">${modules[k1]}</a>
                   		 											<ul>  
                   		 											<#list modules?keys as k2>
                   		 												<li>
                   		 												<#if k2 == "50220">
                   		 													<a href="#">${modules[k2]}</a>                   		 									                   		 						                		 		
                   		 												</#if>
                   		 												<#if k2 == "50221">
                   		 													<a href="#">${modules[k2]}</a>                   		 									                   		 						                		 		
                   		 												</#if>
                   		 												<#if k2 == "50222">
                   		 													<a href="#">${modules[k2]}</a>                   		 									                   		 						                		 		
                   		 												</#if> 
                   		 												<#if k2 == "50223">
                   		 													<a href="#">${modules[k2]}</a>                   		 									                   		 						                		 		
                   		 												</#if>
                   		 									<#if k1 == "5012">
                   		 										<a href="#">${modules[k1]}</a>                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 									
                   		 								</li>                   		 	
                   		 							</#list>
                   		 						</ul>                   		 									                   		 						                		 		
                   		 									</#if>                   		 								               		 									
                   		 								</li>                   		 	
                   		 							</#list>
                   		 						</ul>
                   		 				</#if>                   		 				                		 			        		 					
                   		 			</li>                   		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				<#if key == "600">
					<li >
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>
                   		 			<li>
                   		 				<#if k == "601">
                   		 					<a href="#">${modules[k]}</a>                   		 										                		 		
                   		 				</#if>
                   		 				<#if k == "602">
                   		 					<a href="#">${modules[k]}</a>
               		 					</#if>                   		 				                   		 			        		 					
                   		 			</li>                   		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				<#if key == "700">
					<li >
                   		<a href="#">${modules[key]}</a>
                   		    <ul>  
                   		 		<#list modules?keys as k>
                   		 			<li>
                   		 				<#if k == "701">
                   		 					<a href="#">${modules[k]}</a>                   		 										                		 		
                   		 				</#if>
                   		 				<#if k == "702">
                   		 					<a href="#">${modules[k]}</a>
               		 					</#if>
               		 					<#if k == "703">
                   		 					<a href="#">${modules[k]}</a>                   		 										                		 		
                   		 				</#if>
                   		 				<#if k == "704">
                   		 					<a href="#">${modules[k]}</a>
               		 					</#if>                   		 				                   		 			        		 					
                   		 			</li>                   		 	
                   		 		</#list>
                   		 	</ul>                   		              
                    </li>
				</#if>
				</ul>				
			</#list>
			<li >
                   		<a href="#">SAP LOGON</a>                   		                       		              
            </li>
			
		</div>	

