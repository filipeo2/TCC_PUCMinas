## POC #2 - Integração entre sistemas

O vídeo desta demonstração está disponível no [YouTube](https://youtu.be/I3X2DZ6-n7Q)

O código fonte desta POC está disponível na pasta [Códigos fonte](./Codigos&nbsp;Fontes)

***

## Instruções

#### 1º - Instanciar serviço SOAP e instalá-lo no Windows (também pode ser executado a partir da *Solution* aberta no Visual Studio)
- Navegar até a pasta [soap-service](./soap-service) utilizando o terminal `Developer Command Prompt` que acompanha a instalação do Visual Studio e está disponível em:
```
%WINDIR%\Microsoft.NET\Framework64\v<framework_version>
```
- Instalar o serviço Windows 'CovidServiceHost.exe' utilizando o utilitário `installutil` (que também acompanha o Visual Studio no mesmo diretório acima)
```
installutil.exe CovidServiceHost.exe
```

*Para detalhes sobre a instalação de serviços: https://docs.microsoft.com/pt-br/dotnet/framework/windows-services/how-to-install-and-uninstall-services* 

*Obs.: O `CovidServiceHost.exe` é apenas o hospedeiro e possui os métodos de instalação exigidos pelo Windows. O serviço SOAP é fornecido pela DLL `CovidWcf.dll`. Ambos precisam estar no mesmo diretório.*

- Iniciar o serviço recém-instalado `WCFCovidService` utilizando o console de gerenciamento de serviços do Windows `services.msc` ou através do Gerenciador de Tarefas, aba Serviços (no Windows 10)

Após a instalação ter sido concluída e o serviço Windows iniciado, o webservice pode ser testado utilizando um cliente SOAP (`SOAP UI`, por exemplo), através da URL:
```
http://localhost:8733/Design_Time_Addresses/CovidWcf/Service1/?singlewsdl
```

- É necessário preencher o parâmetro de data no corpo da requisição, conforme exemplo abaixo:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:GetCovidByDate>
         <tem:from>2020-11-01</tem:from>
      </tem:GetCovidByDate>
   </soapenv:Body>
</soapenv:Envelope>
```

*Obs.: O padrão de data aceito pelo path parameter é `yyyy-mm-dd` e as datas consultáveis cadastradas vão de 01/11/2020 até 28/02/2021*

#### 2º - Instanciar o serviço de integração REST -> SOAP
- Navegar até a pasta [camel-integration](./camel-integration) utilizando o terminal do sistema operacional
- Executar: 
```
java -jar integracao-camel-1.0.0-SNAPSHOT.jar
```
*Obs.: Utilizar o Java 1.8*

Após a aplicação ter sido iniciada, este serviço SOAP pode ser testado utilizando algum cliente de API's (`Postman`, por exemplo) através da URL:
```
http://localhost:8734/CovidREST/covid/2020-11-01
```
Diferentemente da requisição SOAP anterior, não é necessário passar nenhum conteúdo no *body*.

*Obs.: O padrão de data aceito pelo path parameter é `yyyy-mm-dd` e as datas consultáveis cadastradas vão de 01/11/2020 até 28/02/2021*

#### 3º - Iniciar a aplicação web localmente (vide Case 1) se quiser visualizar os dados preenchidos na WebApplication