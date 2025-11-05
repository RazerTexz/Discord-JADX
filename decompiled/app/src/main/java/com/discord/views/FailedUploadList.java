package com.discord.views;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.i.d2;
import com.discord.R;
import com.discord.api.message.LocalAttachment;
import com.discord.utilities.attachments.AttachmentUtilsKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.SendUtilsKt;
import com.lytefast.flexinput.model.Attachment;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FailedUploadList.kt */
/* loaded from: classes2.dex */
public final class FailedUploadList extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final d2 binding;

    /* compiled from: FailedUploadList.kt */
    public static final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final long f2828b;
        public final String c;

        public a(String str, long j, String str2) {
            m.checkNotNullParameter(str, "displayName");
            m.checkNotNullParameter(str2, "mimeType");
            this.a = str;
            this.f2828b = j;
            this.c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.areEqual(this.a, aVar.a) && this.f2828b == aVar.f2828b && m.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            String str = this.a;
            int iA = (a0.a.a.b.a(this.f2828b) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            String str2 = this.c;
            return iA + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("SingleFailedUpload(displayName=");
            sbU.append(this.a);
            sbU.append(", sizeBytes=");
            sbU.append(this.f2828b);
            sbU.append(", mimeType=");
            return b.d.b.a.a.J(sbU, this.c, ")");
        }
    }

    /* compiled from: FailedUploadList.kt */
    public static abstract class b {

        /* compiled from: FailedUploadList.kt */
        public static final class a extends b {
            public final List<a> a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(List<a> list) {
                super(null);
                m.checkNotNullParameter(list, "uploads");
                this.a = list;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && m.areEqual(this.a, ((a) obj).a);
                }
                return true;
            }

            public int hashCode() {
                List<a> list = this.a;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.L(b.d.b.a.a.U("FewFailedUploads(uploads="), this.a, ")");
            }
        }

        /* compiled from: FailedUploadList.kt */
        /* renamed from: com.discord.views.FailedUploadList$b$b, reason: collision with other inner class name */
        public static final class C0354b extends b {
            public final int a;

            /* renamed from: b, reason: collision with root package name */
            public final long f2829b;

            public C0354b(int i, long j) {
                super(null);
                this.a = i;
                this.f2829b = j;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0354b)) {
                    return false;
                }
                C0354b c0354b = (C0354b) obj;
                return this.a == c0354b.a && this.f2829b == c0354b.f2829b;
            }

            public int hashCode() {
                return a0.a.a.b.a(this.f2829b) + (this.a * 31);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("ManyFailedUploads(uploadCount=");
                sbU.append(this.a);
                sbU.append(", sizeBytes=");
                return b.d.b.a.a.C(sbU, this.f2829b, ")");
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public FailedUploadList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_chat_upload_list, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.chat_upload_1;
        FailedUploadView failedUploadView = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_1);
        if (failedUploadView != null) {
            i = R.id.chat_upload_2;
            FailedUploadView failedUploadView2 = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_2);
            if (failedUploadView2 != null) {
                i = R.id.chat_upload_3;
                FailedUploadView failedUploadView3 = (FailedUploadView) viewInflate.findViewById(R.id.chat_upload_3);
                if (failedUploadView3 != null) {
                    d2 d2Var = new d2((LinearLayout) viewInflate, failedUploadView, failedUploadView2, failedUploadView3);
                    m.checkNotNullExpressionValue(d2Var, "ViewChatUploadListBindin…rom(context), this, true)");
                    this.binding = d2Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final List<FailedUploadView> getFailedUploadViews() {
        FailedUploadView failedUploadView = this.binding.f98b;
        m.checkNotNullExpressionValue(failedUploadView, "binding.chatUpload1");
        FailedUploadView failedUploadView2 = this.binding.c;
        m.checkNotNullExpressionValue(failedUploadView2, "binding.chatUpload2");
        FailedUploadView failedUploadView3 = this.binding.d;
        m.checkNotNullExpressionValue(failedUploadView3, "binding.chatUpload3");
        return n.listOf((Object[]) new FailedUploadView[]{failedUploadView, failedUploadView2, failedUploadView3});
    }

    public final void setUp(List<LocalAttachment> localAttachments) {
        Object c0354b;
        m.checkNotNullParameter(localAttachments, "localAttachments");
        Iterator<T> it = getFailedUploadViews().iterator();
        while (it.hasNext()) {
            ((FailedUploadView) it.next()).setVisibility(8);
        }
        if (!localAttachments.isEmpty()) {
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(localAttachments, 10));
            Iterator<T> it2 = localAttachments.iterator();
            while (it2.hasNext()) {
                arrayList.add(AttachmentUtilsKt.toAttachment((LocalAttachment) it2.next()));
            }
            if (arrayList.size() <= 3) {
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Attachment attachment = (Attachment) it3.next();
                    String displayName = attachment.getDisplayName();
                    Uri uri = attachment.getUri();
                    Context context = getContext();
                    m.checkNotNullExpressionValue(context, "context");
                    ContentResolver contentResolver = context.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                    long jComputeFileSizeBytes = SendUtilsKt.computeFileSizeBytes(uri, contentResolver);
                    Context context2 = getContext();
                    m.checkNotNullExpressionValue(context2, "context");
                    arrayList2.add(new a(displayName, jComputeFileSizeBytes, AttachmentUtilsKt.getMimeType(attachment, context2.getContentResolver())));
                }
                c0354b = new b.a(arrayList2);
            } else {
                long jComputeFileSizeBytes2 = 0;
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    Uri uri2 = ((Attachment) it4.next()).getUri();
                    Context context3 = getContext();
                    m.checkNotNullExpressionValue(context3, "context");
                    ContentResolver contentResolver2 = context3.getContentResolver();
                    m.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                    jComputeFileSizeBytes2 += SendUtilsKt.computeFileSizeBytes(uri2, contentResolver2);
                }
                c0354b = new b.C0354b(arrayList.size(), jComputeFileSizeBytes2);
            }
            if (c0354b instanceof b.a) {
                List<a> list = ((b.a) c0354b).a;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    a aVar = list.get(i);
                    FailedUploadView failedUploadView = getFailedUploadViews().get(i);
                    failedUploadView.setVisibility(0);
                    String str = aVar.a;
                    Context context4 = failedUploadView.getContext();
                    m.checkNotNullExpressionValue(context4, "context");
                    failedUploadView.a(str, FileUtilsKt.getIconForFiletype(context4, aVar.c), FileUtilsKt.getSizeSubtitle(aVar.f2828b));
                }
                return;
            }
            if (c0354b instanceof b.C0354b) {
                b.C0354b c0354b2 = (b.C0354b) c0354b;
                int i2 = c0354b2.a;
                long j = c0354b2.f2829b;
                ((View) u.first((List) getFailedUploadViews())).setVisibility(0);
                FailedUploadView failedUploadView2 = (FailedUploadView) u.first((List) getFailedUploadViews());
                Resources resources = failedUploadView2.getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                Context context5 = failedUploadView2.getContext();
                m.checkNotNullExpressionValue(context5, "context");
                CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, context5, R.plurals.uploading_files_failed_count, i2, Integer.valueOf(i2));
                Context context6 = failedUploadView2.getContext();
                m.checkNotNullExpressionValue(context6, "context");
                failedUploadView2.a(quantityString, DrawableCompat.getThemedDrawableRes$default(context6, R.attr.ic_uploads_generic, 0, 2, (Object) null), FileUtilsKt.getSizeSubtitle(j));
            }
        }
    }
}
