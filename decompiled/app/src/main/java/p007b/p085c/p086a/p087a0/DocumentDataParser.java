package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.DocumentData;

/* compiled from: DocumentDataParser.java */
/* renamed from: b.c.a.a0.h, reason: use source file name */
/* loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {

    /* renamed from: a */
    public static final DocumentDataParser f2233a = new DocumentDataParser();

    /* renamed from: b */
    public static final JsonReader2.a f2234b = JsonReader2.a.m616a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* renamed from: a */
    public DocumentData mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        jsonReader2.mo604b();
        String strMo612t = null;
        String strMo612t2 = null;
        float fMo609n = 0.0f;
        int i = 3;
        int iMo610q = 0;
        float fMo609n2 = 0.0f;
        float fMo609n3 = 0.0f;
        int iM627a = 0;
        int iM627a2 = 0;
        float fMo609n4 = 0.0f;
        boolean zMo608f = true;
        while (jsonReader2.mo607e()) {
            switch (jsonReader2.mo615y(f2234b)) {
                case 0:
                    strMo612t = jsonReader2.mo612t();
                    break;
                case 1:
                    strMo612t2 = jsonReader2.mo612t();
                    break;
                case 2:
                    fMo609n = (float) jsonReader2.mo609n();
                    break;
                case 3:
                    int iMo610q2 = jsonReader2.mo610q();
                    i = (iMo610q2 <= 2 && iMo610q2 >= 0) ? C1563b.com$airbnb$lottie$model$DocumentData$Justification$s$values()[iMo610q2] : 3;
                    break;
                case 4:
                    iMo610q = jsonReader2.mo610q();
                    break;
                case 5:
                    fMo609n2 = (float) jsonReader2.mo609n();
                    break;
                case 6:
                    fMo609n3 = (float) jsonReader2.mo609n();
                    break;
                case 7:
                    iM627a = JsonUtils.m627a(jsonReader2);
                    break;
                case 8:
                    iM627a2 = JsonUtils.m627a(jsonReader2);
                    break;
                case 9:
                    fMo609n4 = (float) jsonReader2.mo609n();
                    break;
                case 10:
                    zMo608f = jsonReader2.mo608f();
                    break;
                default:
                    jsonReader2.mo600A();
                    jsonReader2.mo601C();
                    break;
            }
        }
        jsonReader2.mo606d();
        return new DocumentData(strMo612t, strMo612t2, fMo609n, i, iMo610q, fMo609n2, fMo609n3, iM627a, iM627a2, fMo609n4, zMo608f);
    }
}
