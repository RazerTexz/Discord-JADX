package p007b.p225i.p226a.p242c.p279z2;

import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p279z2.p280h.AppInfoTableDecoder;
import p007b.p225i.p226a.p242c.p279z2.p281i.EventMessageDecoder;
import p007b.p225i.p226a.p242c.p279z2.p282j.IcyDecoder;
import p007b.p225i.p226a.p242c.p279z2.p283k.Id3Decoder;
import p007b.p225i.p226a.p242c.p279z2.p284l.SpliceInfoDecoder;

/* JADX INFO: renamed from: b.i.a.c.z2.c, reason: use source file name */
/* JADX INFO: compiled from: MetadataDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MetadataDecoderFactory {

    /* JADX INFO: renamed from: a */
    public static final MetadataDecoderFactory f9136a = new a();

    /* JADX INFO: renamed from: b.i.a.c.z2.c$a */
    /* JADX INFO: compiled from: MetadataDecoderFactory.java */
    public class a implements MetadataDecoderFactory {
        @Override // p007b.p225i.p226a.p242c.p279z2.MetadataDecoderFactory
        /* JADX INFO: renamed from: a */
        public boolean mo3896a(Format2 format2) {
            String str = format2.f7155w;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // p007b.p225i.p226a.p242c.p279z2.MetadataDecoderFactory
        /* JADX INFO: renamed from: b */
        public MetadataDecoder mo3897b(Format2 format2) {
            String str = format2.f7155w;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new AppInfoTableDecoder();
                    case "application/x-icy":
                        return new IcyDecoder();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new EventMessageDecoder();
                    case "application/x-scte35":
                        return new SpliceInfoDecoder();
                }
            }
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    /* JADX INFO: renamed from: a */
    boolean mo3896a(Format2 format2);

    /* JADX INFO: renamed from: b */
    MetadataDecoder mo3897b(Format2 format2);
}
