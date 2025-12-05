package p007b.p109f.p161j.p181p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: LocalContentUriFetchProducer.java */
/* renamed from: b.f.j.p.e0, reason: use source file name */
/* loaded from: classes3.dex */
public class LocalContentUriFetchProducer extends LocalFetchProducer {

    /* renamed from: c */
    public final ContentResolver f4040c;

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.f4040c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: d */
    public EncodedImage2 mo1428d(ImageRequest imageRequest) throws IOException {
        EncodedImage2 encodedImage2M1478c;
        InputStream inputStreamCreateInputStream;
        Uri uri = imageRequest.f19585c;
        Uri uri2 = UriUtil.f3138a;
        boolean z2 = false;
        if (uri.getPath() != null && UriUtil.m1007c(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(UriUtil.f3138a.getPath())) {
            z2 = true;
        }
        if (!z2) {
            if (UriUtil.m1006b(uri)) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.f4040c.openFileDescriptor(uri, "r");
                    Objects.requireNonNull(parcelFileDescriptorOpenFileDescriptor);
                    encodedImage2M1478c = m1478c(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
                } catch (FileNotFoundException unused) {
                    encodedImage2M1478c = null;
                }
                if (encodedImage2M1478c != null) {
                    return encodedImage2M1478c;
                }
            }
            InputStream inputStreamOpenInputStream = this.f4040c.openInputStream(uri);
            Objects.requireNonNull(inputStreamOpenInputStream);
            return m1478c(inputStreamOpenInputStream, -1);
        }
        if (uri.toString().endsWith("/photo")) {
            inputStreamCreateInputStream = this.f4040c.openInputStream(uri);
        } else if (uri.toString().endsWith("/display_photo")) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f4040c.openAssetFileDescriptor(uri, "r");
                Objects.requireNonNull(assetFileDescriptorOpenAssetFileDescriptor);
                inputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
            } catch (IOException unused2) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
        } else {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f4040c, uri);
            if (inputStreamOpenContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + uri);
            }
            inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
        }
        Objects.requireNonNull(inputStreamCreateInputStream);
        return m1478c(inputStreamCreateInputStream, -1);
    }

    @Override // p007b.p109f.p161j.p181p.LocalFetchProducer
    /* renamed from: e */
    public String mo1429e() {
        return "LocalContentUriFetchProducer";
    }
}
