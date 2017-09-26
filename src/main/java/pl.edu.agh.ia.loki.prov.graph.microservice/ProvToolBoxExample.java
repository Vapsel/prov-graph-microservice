package pl.edu.agh.ia.loki.prov.graph.microservice;

import org.openprovenance.prov.interop.InteropFramework;
import org.openprovenance.prov.model.Document;
import org.openprovenance.prov.model.Namespace;
import org.openprovenance.prov.model.ProvFactory;

public class ProvToolBoxExample {



    /**
     * A little provenance goes a long way.
     * ProvToolbox Tutorial 1: creating a provenance document in Java and serializing it
     * to SVG (in a file) and to PROVN (on the console).
     *
     * @author lucmoreau
     * @see <a href="http://blog.provbook.org/2013/10/11/a-little-provenance-goes-a-long-way/">a-little-provenance-goes-a-long-way blog post</a>
     */


    public static final String PROVBOOK_NS = "http://www.provbook.org";
    public static final String PROVBOOK_PREFIX = "provbook";

    public static final String JIM_PREFIX = "jim";
    public static final String JIM_NS = "http://www.cs.rpi.edu/~hendler/";

    private final ProvFactory pFactory;
    private final Namespace ns;
    public ProvToolBoxExample(ProvFactory pFactory) {
        this.pFactory = pFactory;
        ns=new Namespace();
        ns.addKnownNamespaces();
        ns.register(PROVBOOK_PREFIX, PROVBOOK_NS);
        ns.register(JIM_PREFIX, JIM_NS);
    }


    public void doConversions(String filein, String fileout) {
        InteropFramework intF=new InteropFramework();
        Document document=intF.readDocumentFromFile(filein);
        intF.writeDocument(fileout, document);
        intF.writeDocument(System.out, InteropFramework.ProvFormat.TURTLE, document);
    }

    public void closingBanner() {
        System.out.println("");
        System.out.println("*************************");
    }

    public void openingBanner() {
        System.out.println("*************************");
        System.out.println("* Converting document  ");
        System.out.println("*************************");
    }

    public static void main(String [] args) {
        if (args.length!=2) throw new UnsupportedOperationException("main to be called with two filenames");
        String filein=args[0];
        String fileout=args[1];

        ProvToolBoxExample tutorial = new ProvToolBoxExample(InteropFramework.newXMLProvFactory());
        tutorial.openingBanner();
        tutorial.doConversions(filein, fileout);
        tutorial.closingBanner();

    }

    }

