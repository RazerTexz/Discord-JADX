package p007b.p195g.p196a.p198b.p204t;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter;

/* JADX INFO: renamed from: b.g.a.b.t.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultIndenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultIndenter extends DefaultPrettyPrinter.c {

    /* JADX INFO: renamed from: j */
    public static final String f4597j;

    /* JADX INFO: renamed from: k */
    public static final DefaultIndenter f4598k;
    private static final long serialVersionUID = 1;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable unused) {
            property = "\n";
        }
        f4597j = property;
        f4598k = new DefaultIndenter("  ", property);
    }

    public DefaultIndenter() {
        this("  ", f4597j);
    }

    @Override // p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter.b
    /* JADX INFO: renamed from: a */
    public void mo1731a(JsonGenerator jsonGenerator, int i) throws IOException {
        jsonGenerator.mo1642T(this.eol);
        if (i <= 0) {
            return;
        }
        int length = i * this.charsPerLevel;
        while (true) {
            char[] cArr = this.indents;
            if (length <= cArr.length) {
                jsonGenerator.mo1643U(cArr, 0, length);
                return;
            } else {
                jsonGenerator.mo1643U(cArr, 0, cArr.length);
                length -= this.indents.length;
            }
        }
    }

    public DefaultIndenter(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[str.length() * 16];
        int length = 0;
        for (int i = 0; i < 16; i++) {
            str.getChars(0, str.length(), this.indents, length);
            length += str.length();
        }
        this.eol = str2;
    }
}
