package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemUploadProgressBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreMessageUploads;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.views.UploadProgressView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress extends WidgetChatListItem {
    private static final long MODEL_THROTTLE_MS = 100;
    private final WidgetChatListAdapterItemUploadProgressBinding binding;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static abstract class Model {
        public static final int PROGRESS_INDETERMINATE = -1;
        public static final long SIZE_UNKNOWN = -1;

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Few extends Model {
            private final List<Single> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Few(List<Single> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Few copy$default(Few few, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = few.uploads;
                }
                return few.copy(list);
            }

            public final List<Single> component1() {
                return this.uploads;
            }

            public final Few copy(List<Single> uploads) {
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new Few(uploads);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Few) && Intrinsics3.areEqual(this.uploads, ((Few) other).uploads);
                }
                return true;
            }

            public final List<Single> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                List<Single> list = this.uploads;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m824L(outline.m833U("Few(uploads="), this.uploads, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Many extends Model {
            private final int numFiles;
            private final int progress;
            private final long sizeBytes;

            public Many(int i, long j, int i2) {
                super(null);
                this.numFiles = i;
                this.sizeBytes = j;
                this.progress = i2;
            }

            public static /* synthetic */ Many copy$default(Many many, int i, long j, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = many.numFiles;
                }
                if ((i3 & 2) != 0) {
                    j = many.sizeBytes;
                }
                if ((i3 & 4) != 0) {
                    i2 = many.progress;
                }
                return many.copy(i, j, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* renamed from: component2, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* renamed from: component3, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Many copy(int numFiles, long sizeBytes, int progress) {
                return new Many(numFiles, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Many)) {
                    return false;
                }
                Many many = (Many) other;
                return this.numFiles == many.numFiles && this.sizeBytes == many.sizeBytes && this.progress == many.progress;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                return ((C0002b.m3a(this.sizeBytes) + (this.numFiles * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Many(numFiles=");
                sbM833U.append(this.numFiles);
                sbM833U.append(", sizeBytes=");
                sbM833U.append(this.sizeBytes);
                sbM833U.append(", progress=");
                return outline.m814B(sbM833U, this.progress, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final class None extends Model {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Preprocessing extends Model {
            private final String displayName;
            private final String mimeType;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.displayName = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.displayName;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* renamed from: component2, reason: from getter */
            public final String getDisplayName() {
                return this.displayName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String displayName, String mimeType) {
                return new Preprocessing(numFiles, displayName, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.displayName, preprocessing.displayName) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getDisplayName() {
                return this.displayName;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.displayName;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Preprocessing(numFiles=");
                sbM833U.append(this.numFiles);
                sbM833U.append(", displayName=");
                sbM833U.append(this.displayName);
                sbM833U.append(", mimeType=");
                return outline.m822J(sbM833U, this.mimeType, ")");
            }
        }

        /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Single extends Model {
            private final String mimeType;
            private final String name;
            private final int progress;
            private final long sizeBytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Single(String str, String str2, long j, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(str2, "mimeType");
                this.name = str;
                this.mimeType = str2;
                this.sizeBytes = j;
                this.progress = i;
            }

            public static /* synthetic */ Single copy$default(Single single, String str, String str2, long j, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = single.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = single.mimeType;
                }
                String str3 = str2;
                if ((i2 & 4) != 0) {
                    j = single.sizeBytes;
                }
                long j2 = j;
                if ((i2 & 8) != 0) {
                    i = single.progress;
                }
                return single.copy(str, str3, j2, i);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            /* renamed from: component3, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* renamed from: component4, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Single copy(String name, String mimeType, long sizeBytes, int progress) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
                return new Single(name, mimeType, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Single)) {
                    return false;
                }
                Single single = (Single) other;
                return Intrinsics3.areEqual(this.name, single.name) && Intrinsics3.areEqual(this.mimeType, single.mimeType) && this.sizeBytes == single.sizeBytes && this.progress == single.progress;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mimeType;
                return ((C0002b.m3a(this.sizeBytes) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Single(name=");
                sbM833U.append(this.name);
                sbM833U.append(", mimeType=");
                sbM833U.append(this.mimeType);
                sbM833U.append(", sizeBytes=");
                sbM833U.append(this.sizeBytes);
                sbM833U.append(", progress=");
                return outline.m814B(sbM833U, this.progress, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();
        private static final int MAX_DETAILED_UPLOADS = 3;

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getFewUploadsObservable(ModelProvider modelProvider, List list, long j) {
            return modelProvider.getFewUploadsObservable(list, j);
        }

        public static final /* synthetic */ Observable access$getManyUploadsObservable(ModelProvider modelProvider, List list, long j) {
            return modelProvider.getManyUploadsObservable(list, j);
        }

        public static final /* synthetic */ int access$getPercentage(ModelProvider modelProvider, long j, long j2) {
            return modelProvider.getPercentage(j, j2);
        }

        public static final /* synthetic */ Observable access$getSingleUploadObservable(ModelProvider modelProvider, SendUtils.FileUpload fileUpload, long j) {
            return modelProvider.getSingleUploadObservable(fileUpload, j);
        }

        private final Observable<Model.Few> getFewUploadsObservable(List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.getSingleUploadObservable((SendUtils.FileUpload) it.next(), throttleIntervalMs));
            }
            Observable<Model.Few> observableM11065b = Observable.m11065b(arrayList, C8148x872da3c9.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11065b, "Observable\n          .co…{ it as Model.Single }) }");
            return observableM11065b;
        }

        private final Observable<Model.Many> getManyUploadsObservable(List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            for (SendUtils.FileUpload fileUpload : uploads) {
                if (fileUpload.getContentLength() <= 0) {
                    ref$LongRef.element = -1L;
                } else {
                    ref$LongRef.element = fileUpload.getContentLength() + ref$LongRef.element;
                }
            }
            if (ref$LongRef.element <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Many(uploads.size(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n            .…          )\n            )");
                return scalarSynchronousObservable;
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(ObservableExtensionsKt.leadingEdgeThrottle(((SendUtils.FileUpload) it.next()).getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS));
            }
            Observable<Model.Many> observableM11083G = Observable.m11065b(arrayList, C8149x87a029e7.INSTANCE).m11083G(new C8150x87a029e8(ref$LongRef)).m11112r().m11083G(new C8151x87a029e9(uploads, ref$LongRef));
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "Observable\n            .…essPercent)\n            }");
            return observableM11083G;
        }

        private final int getPercentage(long bytesWritten, long contentLengthBytes) {
            float f = bytesWritten;
            if (contentLengthBytes > 0) {
                return (int) ((f / contentLengthBytes) * 100);
            }
            Logger.e$default(AppLog.f14950g, "contentLengthBytes was not positive", new Exception(), null, 4, null);
            return 0;
        }

        private final Observable<Model.Single> getSingleUploadObservable(SendUtils.FileUpload upload, long throttleIntervalMs) {
            if (upload.getContentLength() <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Single(upload.getName(), upload.getMimeType(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …E\n            )\n        )");
                return scalarSynchronousObservable;
            }
            Observable<Model.Single> observableM11083G = ObservableExtensionsKt.leadingEdgeThrottle(upload.getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS).m11083G(new C8152xb525f257(upload)).m11112r().m11083G(new C8153xb525f258(upload));
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "upload\n            .byte…          )\n            }");
            return observableM11083G;
        }

        public final Observable<? extends Model> get(String nonce, long throttleIntervalMs) {
            Intrinsics3.checkNotNullParameter(nonce, "nonce");
            StoreMessageUploads messageUploads = StoreStream.INSTANCE.getMessageUploads();
            Observable<? extends Model> observableM11099Y = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{messageUploads}, false, null, null, new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1(messageUploads, nonce), 14, null).m11099Y(new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(throttleIntervalMs));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "ObservationDeckProvider.…      }\n        }\n      }");
            return observableM11099Y;
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$1 */
    public static final /* synthetic */ class C81541 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C81541(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
            super(1, widgetChatListAdapterItemUploadProgress, WidgetChatListAdapterItemUploadProgress.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemUploadProgress.access$configureUI((WidgetChatListAdapterItemUploadProgress) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$2 */
    public static final class C81552 extends Lambda implements Function1<Subscription, Unit> {
        public C81552() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemUploadProgress.access$setSubscription$p(WidgetChatListAdapterItemUploadProgress.this, subscription);
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$3 */
    public static final class ViewOnClickListenerC81563 implements View.OnClickListener {
        public final /* synthetic */ Function0 $cancel;

        public ViewOnClickListenerC81563(Function0 function0) {
            this.$cancel = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$cancel.invoke();
        }
    }

    /* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$4 */
    public static final class ViewOnClickListenerC81574 implements View.OnClickListener {
        public final /* synthetic */ Function0 $cancel;

        public ViewOnClickListenerC81574(Function0 function0) {
            this.$cancel = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$cancel.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_upload_progress, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.progress_cancel_centered;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.progress_cancel_centered);
        if (imageView != null) {
            i = C5419R.id.progress_cancel_top;
            ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.progress_cancel_top);
            if (imageView2 != null) {
                i = C5419R.id.upload_progress_1;
                UploadProgressView uploadProgressView = (UploadProgressView) view.findViewById(C5419R.id.upload_progress_1);
                if (uploadProgressView != null) {
                    i = C5419R.id.upload_progress_2;
                    UploadProgressView uploadProgressView2 = (UploadProgressView) view.findViewById(C5419R.id.upload_progress_2);
                    if (uploadProgressView2 != null) {
                        i = C5419R.id.upload_progress_3;
                        UploadProgressView uploadProgressView3 = (UploadProgressView) view.findViewById(C5419R.id.upload_progress_3);
                        if (uploadProgressView3 != null) {
                            WidgetChatListAdapterItemUploadProgressBinding widgetChatListAdapterItemUploadProgressBinding = new WidgetChatListAdapterItemUploadProgressBinding((LinearLayout) view, imageView, imageView2, uploadProgressView, uploadProgressView2, uploadProgressView3);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemUploadProgressBinding, "WidgetChatListAdapterIte…essBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemUploadProgressBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, Model model) throws Resources.NotFoundException {
        widgetChatListAdapterItemUploadProgress.configureUI(model);
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
        return widgetChatListAdapterItemUploadProgress.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress, Subscription subscription) {
        widgetChatListAdapterItemUploadProgress.subscription = subscription;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(Model uploadState) throws Resources.NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4 = uploadState instanceof Model.Few;
        if (z4) {
            UploadProgressView uploadProgressView = this.binding.f16351d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView, "binding.uploadProgress1");
            Model.Few few = (Model.Few) uploadState;
            setUploadState(uploadProgressView, few.getUploads().get(0));
            UploadProgressView uploadProgressView2 = this.binding.f16352e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView2, "binding.uploadProgress2");
            setUploadState(uploadProgressView2, few.getUploads().get(1));
            UploadProgressView uploadProgressView3 = this.binding.f16353f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView3, "binding.uploadProgress3");
            uploadProgressView3.setVisibility(0);
            if (few.getUploads().size() == 3) {
                UploadProgressView uploadProgressView4 = this.binding.f16353f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView4, "binding.uploadProgress3");
                uploadProgressView4.setVisibility(0);
                UploadProgressView uploadProgressView5 = this.binding.f16353f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView5, "binding.uploadProgress3");
                setUploadState(uploadProgressView5, few.getUploads().get(2));
            } else {
                UploadProgressView uploadProgressView6 = this.binding.f16353f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView6, "binding.uploadProgress3");
                uploadProgressView6.setVisibility(8);
            }
        } else {
            UploadProgressView uploadProgressView7 = this.binding.f16351d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView7, "binding.uploadProgress1");
            setUploadState(uploadProgressView7, uploadState);
            UploadProgressView uploadProgressView8 = this.binding.f16352e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView8, "binding.uploadProgress2");
            uploadProgressView8.setVisibility(8);
            UploadProgressView uploadProgressView9 = this.binding.f16353f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView9, "binding.uploadProgress3");
            uploadProgressView9.setVisibility(8);
        }
        if ((uploadState instanceof Model.Preprocessing) || ((uploadState instanceof Model.Single) && ((Model.Single) uploadState).getProgress() < 100)) {
            z2 = true;
        } else if (z4) {
            List<Model.Single> uploads = ((Model.Few) uploadState).getUploads();
            if ((uploads instanceof Collection) && uploads.isEmpty()) {
                z3 = false;
                if (z3) {
                }
            } else {
                Iterator<T> it = uploads.iterator();
                while (it.hasNext()) {
                    if (((Model.Single) it.next()).getProgress() < 100) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (z3) {
                    if (!(uploadState instanceof Model.Many) || ((Model.Many) uploadState).getProgress() >= 100) {
                        z2 = false;
                    }
                }
            }
        }
        if (z2) {
            ImageView imageView = this.binding.f16350c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progressCancelTop");
            imageView.setVisibility(z4 ? 0 : 8);
            ImageView imageView2 = this.binding.f16349b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progressCancelCentered");
            imageView2.setVisibility(z4 ^ true ? 0 : 8);
            return;
        }
        ImageView imageView3 = this.binding.f16350c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progressCancelTop");
        imageView3.setVisibility(8);
        ImageView imageView4 = this.binding.f16349b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progressCancelCentered");
        imageView4.setVisibility(8);
    }

    private final void setUploadState(UploadProgressView uploadProgressView, Model model) throws Resources.NotFoundException {
        if (Intrinsics3.areEqual(model, Model.None.INSTANCE)) {
            CharSequence charSequenceM218j = FormatUtils.m218j(uploadProgressView, C5419R.string.upload_queued, new Object[0], null, 4);
            int i = UploadProgressView.f19167j;
            uploadProgressView.m8565a(charSequenceM218j, 0, null);
            Context context = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.ic_uploads_generic, 0, 2, (Object) null));
            return;
        }
        if (model instanceof Model.Preprocessing) {
            Model.Preprocessing preprocessing = (Model.Preprocessing) model;
            CharSequence displayName = preprocessing.getDisplayName();
            if (displayName == null) {
                Resources resources = uploadProgressView.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                Context context2 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "context");
                displayName = StringResourceUtils.getQuantityString(resources, context2, C5419R.plurals.uploading_files_count, preprocessing.getNumFiles(), Integer.valueOf(preprocessing.getNumFiles()));
            }
            int i2 = UploadProgressView.f19167j;
            uploadProgressView.m8565a(displayName, -1, null);
            if (preprocessing.getMimeType() != null) {
                Context context3 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "context");
                uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context3, preprocessing.getMimeType()));
                return;
            } else {
                Context context4 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context4, "context");
                uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context4, C5419R.attr.ic_uploads_generic, 0, 2, (Object) null));
                return;
            }
        }
        if (model instanceof Model.Single) {
            Model.Single single = (Model.Single) model;
            uploadProgressView.m8565a(single.getName(), single.getProgress() != -1 ? single.getProgress() : -1, FileUtils2.getSizeSubtitle(single.getSizeBytes()));
            Context context5 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context5, "context");
            uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context5, single.getMimeType()));
            return;
        }
        if (model instanceof Model.Many) {
            Resources resources2 = uploadProgressView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            Context context6 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context6, "context");
            Model.Many many = (Model.Many) model;
            uploadProgressView.m8565a(StringResourceUtils.getQuantityString(resources2, context6, C5419R.plurals.uploading_files_count, many.getNumFiles(), Integer.valueOf(many.getNumFiles())), many.getProgress() != -1 ? many.getProgress() : -1, FileUtils2.getSizeSubtitle(many.getSizeBytes()));
            Context context7 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context7, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context7, C5419R.attr.ic_uploads_generic, 0, 2, (Object) null));
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Observable<? extends Model> observableM11086L = ModelProvider.INSTANCE.get(((UploadProgressEntry) data).getMessageNonce(), 100L).m11086L();
        Intrinsics3.checkNotNullExpressionValue(observableM11086L, "ModelProvider.get(data.m…  .onBackpressureLatest()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11086L), WidgetChatListAdapterItemUploadProgress.class, (Context) null, new C81552(), (Function1) null, (Function0) null, (Function0) null, new C81541(this), 58, (Object) null);
        WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 = new WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1(data);
        this.binding.f16350c.setOnClickListener(new ViewOnClickListenerC81563(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
        this.binding.f16349b.setOnClickListener(new ViewOnClickListenerC81574(widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1));
    }
}
