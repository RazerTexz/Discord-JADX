package com.discord.utilities.rest;

import android.content.ContentResolver;
import com.discord.app.AppLog;
import com.discord.utilities.attachments.AttachmentUtils;
import com.lytefast.flexinput.model.Attachment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.JvmOkio;
import p615g0.Timeout2;

/* JADX INFO: compiled from: AttachmentRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentRequestBody extends RequestBody {
    private final Attachment<?> attachment;
    private final ContentResolver contentResolver;
    private final long size;

    public AttachmentRequestBody(ContentResolver contentResolver, Attachment<?> attachment) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.contentResolver = contentResolver;
        this.attachment = attachment;
        Object data = attachment.getData();
        File file = (File) (data instanceof File ? data : null);
        this.size = file != null ? file.length() : SendUtils5.computeFileSizeBytes(attachment.getUri(), contentResolver);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.m10968b(AttachmentUtils.getMimeType(this.attachment, this.contentResolver));
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AttachmentRequestBody(attachment=");
        sbM833U.append(this.attachment);
        sbM833U.append(", size=");
        sbM833U.append(this.size);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics3.checkNotNullParameter(sink, "sink");
        try {
            InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(this.attachment.getUri());
            if (inputStreamOpenInputStream == null) {
                return;
            }
            try {
                Intrinsics3.checkNotNullExpressionValue(inputStreamOpenInputStream, "inputStream");
                Intrinsics3.checkParameterIsNotNull(inputStreamOpenInputStream, "$this$source");
                JvmOkio jvmOkio = new JvmOkio(inputStreamOpenInputStream, new Timeout2());
                try {
                    sink.mo10440P(jvmOkio);
                    Closeable.closeFinally(jvmOkio, null);
                    Closeable.closeFinally(inputStreamOpenInputStream, null);
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AppLog.f14950g.mo8367i("Could not write to sink", e);
            throw e;
        }
    }
}
