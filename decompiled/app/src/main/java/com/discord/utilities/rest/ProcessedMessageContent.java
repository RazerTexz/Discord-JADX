package com.discord.utilities.rest;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.t.u;
import d0.y.b;
import d0.z.d.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SendUtils.kt */
/* loaded from: classes2.dex */
public final /* data */ class ProcessedMessageContent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final List<Attachment<?>> invalidAttachments;
    private final List<Attachment<?>> validAttachments;

    /* compiled from: SendUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isUriValid(Uri uri, ContentResolver contentResolver) {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    b.closeFinally(inputStreamOpenInputStream, null);
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final ProcessedMessageContent fromAttachments(List<? extends Attachment<?>> attachments, String content, Context context) {
            m.checkNotNullParameter(attachments, "attachments");
            m.checkNotNullParameter(content, "content");
            m.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            List<Attachment<?>> listExtractLinks = AttachmentUtilsKt.extractLinks(attachments, contentResolver);
            String strAppendLinks = AttachmentUtilsKt.appendLinks(content, listExtractLinks);
            for (Attachment attachment : u.minus((Iterable) attachments, (Iterable) listExtractLinks)) {
                Uri uri = attachment.getUri();
                ContentResolver contentResolver2 = context.getContentResolver();
                m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                if (isUriValid(uri, contentResolver2)) {
                    arrayList.add(attachment);
                } else {
                    arrayList2.add(attachment);
                }
            }
            return new ProcessedMessageContent(arrayList, arrayList2, strAppendLinks);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProcessedMessageContent(List<? extends Attachment<?>> list, List<? extends Attachment<?>> list2, String str) {
        m.checkNotNullParameter(list, "validAttachments");
        m.checkNotNullParameter(list2, "invalidAttachments");
        m.checkNotNullParameter(str, "content");
        this.validAttachments = list;
        this.invalidAttachments = list2;
        this.content = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProcessedMessageContent copy$default(ProcessedMessageContent processedMessageContent, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = processedMessageContent.validAttachments;
        }
        if ((i & 2) != 0) {
            list2 = processedMessageContent.invalidAttachments;
        }
        if ((i & 4) != 0) {
            str = processedMessageContent.content;
        }
        return processedMessageContent.copy(list, list2, str);
    }

    public final List<Attachment<?>> component1() {
        return this.validAttachments;
    }

    public final List<Attachment<?>> component2() {
        return this.invalidAttachments;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ProcessedMessageContent copy(List<? extends Attachment<?>> validAttachments, List<? extends Attachment<?>> invalidAttachments, String content) {
        m.checkNotNullParameter(validAttachments, "validAttachments");
        m.checkNotNullParameter(invalidAttachments, "invalidAttachments");
        m.checkNotNullParameter(content, "content");
        return new ProcessedMessageContent(validAttachments, invalidAttachments, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessedMessageContent)) {
            return false;
        }
        ProcessedMessageContent processedMessageContent = (ProcessedMessageContent) other;
        return m.areEqual(this.validAttachments, processedMessageContent.validAttachments) && m.areEqual(this.invalidAttachments, processedMessageContent.invalidAttachments) && m.areEqual(this.content, processedMessageContent.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Attachment<?>> getInvalidAttachments() {
        return this.invalidAttachments;
    }

    public final List<Attachment<?>> getValidAttachments() {
        return this.validAttachments;
    }

    public int hashCode() {
        List<Attachment<?>> list = this.validAttachments;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Attachment<?>> list2 = this.invalidAttachments;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.content;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ProcessedMessageContent(validAttachments=");
        sbU.append(this.validAttachments);
        sbU.append(", invalidAttachments=");
        sbU.append(this.invalidAttachments);
        sbU.append(", content=");
        return a.J(sbU, this.content, ")");
    }
}
