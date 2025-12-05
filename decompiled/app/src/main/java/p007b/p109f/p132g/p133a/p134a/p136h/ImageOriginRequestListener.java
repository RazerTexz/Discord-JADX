package p007b.p109f.p132g.p133a.p134a.p136h;

import p007b.p109f.p161j.p176k.BaseRequestListener;

/* compiled from: ImageOriginRequestListener.java */
/* renamed from: b.f.g.a.a.h.c, reason: use source file name */
/* loaded from: classes.dex */
public class ImageOriginRequestListener extends BaseRequestListener {

    /* renamed from: a */
    public String f3200a;

    /* renamed from: b */
    public final ImageOriginListener f3201b;

    public ImageOriginRequestListener(String str, ImageOriginListener imageOriginListener) {
        this.f3201b = imageOriginListener;
        this.f3200a = str;
    }

    @Override // p007b.p109f.p161j.p176k.BaseRequestListener, p007b.p109f.p161j.p181p.ProducerListener
    /* renamed from: e */
    public void mo1062e(String str, String str2, boolean z2) {
        int i;
        ImageOriginListener imageOriginListener = this.f3201b;
        if (imageOriginListener != null) {
            String str3 = this.f3200a;
            str2.hashCode();
            i = 1;
            switch (str2) {
                case "QualifiedResourceFetchProducer":
                case "LocalResourceFetchProducer":
                case "LocalFileFetchProducer":
                case "VideoThumbnailProducer":
                case "LocalAssetFetchProducer":
                case "DataFetchProducer":
                case "LocalContentUriThumbnailFetchProducer":
                case "LocalContentUriFetchProducer":
                    i = 7;
                    break;
                case "BitmapMemoryCacheGetProducer":
                case "BitmapMemoryCacheProducer":
                case "PostprocessedBitmapMemoryCacheProducer":
                    i = 5;
                    break;
                case "EncodedMemoryCacheProducer":
                    i = 4;
                    break;
                case "NetworkFetchProducer":
                    i = 2;
                    break;
                case "DiskCacheProducer":
                case "PartialDiskCacheProducer":
                    i = 3;
                    break;
            }
            imageOriginListener.mo1061a(str3, i, z2, str2);
        }
    }
}
