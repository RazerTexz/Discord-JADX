package p007b.p225i.p226a.p242c.p279z2.p280h;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p279z2.MetadataInputBuffer;
import p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder;
import p007b.p225i.p355b.p356a.Charsets;

/* JADX INFO: renamed from: b.i.a.c.z2.h.a, reason: use source file name */
/* JADX INFO: compiled from: AppInfoTableDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    @Override // p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder
    @Nullable
    /* JADX INFO: renamed from: b */
    public Metadata mo3899b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            ParsableBitArray parsableBitArray = new ParsableBitArray(byteBuffer.array(), byteBuffer.limit());
            parsableBitArray.m3073m(12);
            int iM3064d = (parsableBitArray.m3064d() + parsableBitArray.m3067g(12)) - 4;
            parsableBitArray.m3073m(44);
            parsableBitArray.m3074n(parsableBitArray.m3067g(12));
            parsableBitArray.m3073m(16);
            ArrayList arrayList = new ArrayList();
            while (parsableBitArray.m3064d() < iM3064d) {
                parsableBitArray.m3073m(48);
                int iM3067g = parsableBitArray.m3067g(8);
                parsableBitArray.m3073m(4);
                int iM3064d2 = parsableBitArray.m3064d() + parsableBitArray.m3067g(12);
                String str = null;
                String str2 = null;
                while (parsableBitArray.m3064d() < iM3064d2) {
                    int iM3067g2 = parsableBitArray.m3067g(8);
                    int iM3067g3 = parsableBitArray.m3067g(8);
                    int iM3064d3 = parsableBitArray.m3064d() + iM3067g3;
                    if (iM3067g2 == 2) {
                        int iM3067g4 = parsableBitArray.m3067g(16);
                        parsableBitArray.m3073m(8);
                        if (iM3067g4 == 3) {
                            while (parsableBitArray.m3064d() < iM3064d3) {
                                int iM3067g5 = parsableBitArray.m3067g(8);
                                Charset charset = Charsets.f11943a;
                                byte[] bArr = new byte[iM3067g5];
                                parsableBitArray.m3069i(bArr, 0, iM3067g5);
                                str = new String(bArr, charset);
                                int iM3067g6 = parsableBitArray.m3067g(8);
                                for (int i = 0; i < iM3067g6; i++) {
                                    parsableBitArray.m3074n(parsableBitArray.m3067g(8));
                                }
                            }
                        }
                    } else if (iM3067g2 == 21) {
                        Charset charset2 = Charsets.f11943a;
                        byte[] bArr2 = new byte[iM3067g3];
                        parsableBitArray.m3069i(bArr2, 0, iM3067g3);
                        str2 = new String(bArr2, charset2);
                    }
                    parsableBitArray.m3071k(iM3064d3 * 8);
                }
                parsableBitArray.m3071k(iM3064d2 * 8);
                if (str != null && str2 != null) {
                    arrayList.add(new AppInfoTable(iM3067g, str2.length() != 0 ? str.concat(str2) : new String(str)));
                }
            }
            if (!arrayList.isEmpty()) {
                return new Metadata(arrayList);
            }
        }
        return null;
    }
}
