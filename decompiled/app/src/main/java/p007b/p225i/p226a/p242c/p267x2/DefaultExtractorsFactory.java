package p007b.p225i.p226a.p242c.p267x2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p267x2.p268c0.AmrExtractor;
import p007b.p225i.p226a.p242c.p267x2.p269d0.FlacExtractor;
import p007b.p225i.p226a.p242c.p267x2.p270e0.FlvExtractor;
import p007b.p225i.p226a.p242c.p267x2.p271f0.JpegExtractor;
import p007b.p225i.p226a.p242c.p267x2.p272g0.MatroskaExtractor;
import p007b.p225i.p226a.p242c.p267x2.p273h0.Mp3Extractor;
import p007b.p225i.p226a.p242c.p267x2.p274i0.FragmentedMp4Extractor;
import p007b.p225i.p226a.p242c.p267x2.p274i0.Mp4Extractor;
import p007b.p225i.p226a.p242c.p267x2.p275j0.OggExtractor;
import p007b.p225i.p226a.p242c.p267x2.p276k0.Ac3Extractor;
import p007b.p225i.p226a.p242c.p267x2.p276k0.Ac4Extractor;
import p007b.p225i.p226a.p242c.p267x2.p276k0.AdtsExtractor;
import p007b.p225i.p226a.p242c.p267x2.p276k0.PsExtractor;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsExtractor;
import p007b.p225i.p226a.p242c.p267x2.p277l0.WavExtractor;

/* compiled from: DefaultExtractorsFactory.java */
/* renamed from: b.i.a.c.x2.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory2 {

    /* renamed from: a */
    public static final int[] f8151a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* renamed from: b */
    public static final a f8152b = new a();

    /* compiled from: DefaultExtractorsFactory.java */
    /* renamed from: b.i.a.c.x2.f$a */
    public static final class a {

        /* renamed from: a */
        public final AtomicBoolean f8153a = new AtomicBoolean(false);

        /* renamed from: b */
        @Nullable
        @GuardedBy("extensionLoaded")
        public Constructor<? extends Extractor> f8154b;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* renamed from: a */
    public synchronized Extractor[] mo3630a() {
        return mo3631b(Uri.EMPTY, new HashMap());
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* renamed from: b */
    public synchronized Extractor[] mo3631b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int iM460O0 = AnimatableValueParser.m460O0(map);
        if (iM460O0 != -1) {
            m3664c(iM460O0, arrayList);
        }
        int iM463P0 = AnimatableValueParser.m463P0(uri);
        if (iM463P0 != -1 && iM463P0 != iM460O0) {
            m3664c(iM463P0, arrayList);
        }
        for (int i : f8151a) {
            if (i != iM460O0 && i != iM463P0) {
                m3664c(i, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    /* renamed from: c */
    public final void m3664c(int i, List<Extractor> list) {
        Extractor extractorNewInstance;
        Constructor<? extends Extractor> constructor;
        switch (i) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                list.add(new AdtsExtractor(0));
                return;
            case 3:
                list.add(new AmrExtractor(0));
                return;
            case 4:
                a aVar = f8152b;
                synchronized (aVar.f8153a) {
                    extractorNewInstance = null;
                    if (aVar.f8153a.get()) {
                        constructor = aVar.f8154b;
                    } else {
                        try {
                            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                                aVar.f8154b = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
                            }
                            break;
                        } catch (ClassNotFoundException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Error instantiating FLAC extension", e);
                        }
                        aVar.f8153a.set(true);
                        constructor = aVar.f8154b;
                    }
                }
                if (constructor != null) {
                    try {
                        extractorNewInstance = constructor.newInstance(0);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
                if (extractorNewInstance != null) {
                    list.add(extractorNewInstance);
                    return;
                } else {
                    list.add(new FlacExtractor(0));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(0));
                return;
            case 7:
                list.add(new Mp3Extractor(0));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(0));
                list.add(new Mp4Extractor(0));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(1, 0, 112800));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new JpegExtractor());
                return;
        }
    }
}
