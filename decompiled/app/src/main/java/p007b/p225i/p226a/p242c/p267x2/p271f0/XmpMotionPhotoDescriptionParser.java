package p007b.p225i.p226a.p242c.p267x2.p271f0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p267x2.p271f0.MotionPhotoDescription;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableCollection;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: XmpMotionPhotoDescriptionParser.java */
/* renamed from: b.i.a.c.x2.f0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class XmpMotionPhotoDescriptionParser {

    /* renamed from: a */
    public static final String[] f8176a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b */
    public static final String[] f8177b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c */
    public static final String[] f8178c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        r10 = -9223372036854775807L;
     */
    @Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MotionPhotoDescription m3668a(String str) throws XmlPullParserException, IOException {
        boolean z2;
        long j;
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!AnimatableValueParser.m490Y0(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.m8755a("Couldn't find xmp metadata", null);
        }
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        ImmutableList2<Object> immutableList2M3669b = RegularImmutableList.f12012l;
        long j2 = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (AnimatableValueParser.m490Y0(xmlPullParserNewPullParser, "rdf:Description")) {
                String[] strArr = f8176a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String strM564r0 = AnimatableValueParser.m564r0(xmlPullParserNewPullParser, strArr[i]);
                    if (strM564r0 != null) {
                        z2 = Integer.parseInt(strM564r0) == 1;
                    } else {
                        i++;
                    }
                }
                if (!z2) {
                    return null;
                }
                String[] strArr2 = f8177b;
                int length2 = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    }
                    String strM564r02 = AnimatableValueParser.m564r0(xmlPullParserNewPullParser, strArr2[i2]);
                    if (strM564r02 != null) {
                        j = Long.parseLong(strM564r02);
                        if (j == -1) {
                            break;
                        }
                    } else {
                        i2++;
                    }
                }
                String[] strArr3 = f8178c;
                int length3 = strArr3.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length3) {
                        AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.f12045k;
                        immutableList2M3669b = RegularImmutableList.f12012l;
                        break;
                    }
                    String strM564r03 = AnimatableValueParser.m564r0(xmlPullParserNewPullParser, strArr3[i3]);
                    if (strM564r03 != null) {
                        long j3 = Long.parseLong(strM564r03);
                        MotionPhotoDescription.a aVar = new MotionPhotoDescription.a("image/jpeg", "Primary", 0L, 0L);
                        MotionPhotoDescription.a aVar2 = new MotionPhotoDescription.a("video/mp4", "MotionPhoto", j3, 0L);
                        AbstractIndexedListIterator<Object> abstractIndexedListIterator3 = ImmutableList2.f12045k;
                        immutableList2M3669b = ImmutableList2.m6263m(aVar, aVar2);
                        break;
                    }
                    i3++;
                }
                j2 = j;
            } else if (AnimatableValueParser.m490Y0(xmlPullParserNewPullParser, "Container:Directory")) {
                immutableList2M3669b = m3669b(xmlPullParserNewPullParser, "Container", "Item");
            } else if (AnimatableValueParser.m490Y0(xmlPullParserNewPullParser, "GContainer:Directory")) {
                immutableList2M3669b = m3669b(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!AnimatableValueParser.m469R0(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (immutableList2M3669b.isEmpty()) {
            return null;
        }
        return new MotionPhotoDescription(j2, immutableList2M3669b);
    }

    /* renamed from: b */
    public static ImmutableList2<MotionPhotoDescription.a> m3669b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        int i = 0;
        do {
            xmlPullParser.next();
            if (AnimatableValueParser.m490Y0(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strM564r0 = AnimatableValueParser.m564r0(xmlPullParser, strConcat3);
                String strM564r02 = AnimatableValueParser.m564r0(xmlPullParser, strConcat4);
                String strM564r03 = AnimatableValueParser.m564r0(xmlPullParser, strConcat5);
                String strM564r04 = AnimatableValueParser.m564r0(xmlPullParser, strConcat6);
                if (strM564r0 == null || strM564r02 == null) {
                    return RegularImmutableList.f12012l;
                }
                MotionPhotoDescription.a aVar = new MotionPhotoDescription.a(strM564r0, strM564r02, strM564r03 != null ? Long.parseLong(strM564r03) : 0L, strM564r04 != null ? Long.parseLong(strM564r04) : 0L);
                int i2 = i + 1;
                if (objArrCopyOf.length < i2) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i2));
                }
                objArrCopyOf[i] = aVar;
                i = i2;
            }
        } while (!AnimatableValueParser.m469R0(xmlPullParser, strConcat2));
        return ImmutableList2.m6262l(objArrCopyOf, i);
    }
}
