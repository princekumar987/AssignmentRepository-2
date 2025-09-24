

interface IReports{

    public String getJsonData(String data);

}
// Adaptee:--

class XmlDataProvider{

    String getXmlData(String data){

        int sep=data.indexOf(":");
        String name=data.substring(0,sep);
        String id=data.substring(sep+1);

        //build xml data

        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>"   + id   + "</id>"
                + "</user>";
    }
}

class XmlDataProviderAdapter implements IReports {

    private XmlDataProvider xmlDataProvider;

    public XmlDataProviderAdapter(XmlDataProvider xmlDataProvider){
        this.xmlDataProvider=xmlDataProvider;
    }


    @Override
    public String getJsonData(String data) {

        // 1. Get XML from the adaptee
        String xml=xmlDataProvider.getXmlData(data);

        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);


        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}

// 4. Client code works only with IReports
class Client {
    public void getReport(IReports report, String rawData) {
        System.out.println("Processed JSON: "
                + report.getJsonData(rawData));
    }
}


public class AdapterDesignPattern {

    public static void main(String[] args) {

        XmlDataProvider xmlpro=new XmlDataProvider();

        IReports adapter=new XmlDataProviderAdapter(xmlpro);

        String rawdata="Alice:22";

        Client client=new Client();

        client.getReport(adapter,rawdata);

    }

}
