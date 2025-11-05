package com.discord.widgets.bugreports;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.bugreport.BugReportConfig;
import com.discord.api.bugreport.Feature;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import d0.c0.c;
import d0.d0.f;
import d0.g0.w;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: BugReportViewModel.kt */
/* loaded from: classes2.dex */
public final class BugReportViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Feature> genericFeatureAreas = m.listOf(new Feature(NotificationClient.NOTIF_GENERAL, "Android", null));
    private static final List<Sticker> sendingStickers;
    private static final List<Sticker> successStickers;
    private RestCallState<BugReportConfig> bugReportConfig;
    private final PublishSubject<Event> eventSubject;
    private Feature feature;
    private String featureSearchQuery;
    private Integer priority;
    private String reportDescription;
    private String reportName;
    private final RestAPI restApi;
    private final String screenshotName;
    private final Uri screenshotUri;
    private final Sticker sendingSticker;
    private final int stickerCharacterIndex;
    private boolean stickersPrefetched;
    private final Sticker successSticker;
    private boolean useScreenshot;

    /* compiled from: BugReportViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Feature> getGenericFeatureAreas() {
            return BugReportViewModel.access$getGenericFeatureAreas$cp();
        }

        public final List<Sticker> getSendingStickers() {
            return BugReportViewModel.access$getSendingStickers$cp();
        }

        public final List<Sticker> getSuccessStickers() {
            return BugReportViewModel.access$getSuccessStickers$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    public static abstract class Event {

        /* compiled from: BugReportViewModel.kt */
        public static final class CloseReport extends Event {
            public static final CloseReport INSTANCE = new CloseReport();

            private CloseReport() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: BugReportViewModel.kt */
        public static final /* data */ class Report extends ViewState {
            private final Error error;
            private final Feature feature;
            private final Integer priority;
            private final String reportDescription;
            private final String reportName;
            private final Uri screenshotUri;
            private final boolean useScreenshot;

            public /* synthetic */ Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(uri, str, str2, num, feature, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : error);
            }

            public static /* synthetic */ Report copy$default(Report report, Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = report.screenshotUri;
                }
                if ((i & 2) != 0) {
                    str = report.reportName;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    str2 = report.reportDescription;
                }
                String str4 = str2;
                if ((i & 8) != 0) {
                    num = report.priority;
                }
                Integer num2 = num;
                if ((i & 16) != 0) {
                    feature = report.feature;
                }
                Feature feature2 = feature;
                if ((i & 32) != 0) {
                    z2 = report.useScreenshot;
                }
                boolean z3 = z2;
                if ((i & 64) != 0) {
                    error = report.error;
                }
                return report.copy(uri, str3, str4, num2, feature2, z3, error);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            /* renamed from: component2, reason: from getter */
            public final String getReportName() {
                return this.reportName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getReportDescription() {
                return this.reportDescription;
            }

            /* renamed from: component4, reason: from getter */
            public final Integer getPriority() {
                return this.priority;
            }

            /* renamed from: component5, reason: from getter */
            public final Feature getFeature() {
                return this.feature;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* renamed from: component7, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final Report copy(Uri screenshotUri, String reportName, String reportDescription, Integer priority, Feature feature, boolean useScreenshot, Error error) {
                d0.z.d.m.checkNotNullParameter(screenshotUri, "screenshotUri");
                return new Report(screenshotUri, reportName, reportDescription, priority, feature, useScreenshot, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Report)) {
                    return false;
                }
                Report report = (Report) other;
                return d0.z.d.m.areEqual(this.screenshotUri, report.screenshotUri) && d0.z.d.m.areEqual(this.reportName, report.reportName) && d0.z.d.m.areEqual(this.reportDescription, report.reportDescription) && d0.z.d.m.areEqual(this.priority, report.priority) && d0.z.d.m.areEqual(this.feature, report.feature) && this.useScreenshot == report.useScreenshot && d0.z.d.m.areEqual(this.error, report.error);
            }

            public final Error getError() {
                return this.error;
            }

            public final Feature getFeature() {
                return this.feature;
            }

            public final Integer getPriority() {
                return this.priority;
            }

            public final String getReportDescription() {
                return this.reportDescription;
            }

            public final String getReportName() {
                return this.reportName;
            }

            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Uri uri = this.screenshotUri;
                int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
                String str = this.reportName;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.reportDescription;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                Integer num = this.priority;
                int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
                Feature feature = this.feature;
                int iHashCode5 = (iHashCode4 + (feature != null ? feature.hashCode() : 0)) * 31;
                boolean z2 = this.useScreenshot;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                Error error = this.error;
                return i2 + (error != null ? error.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Report(screenshotUri=");
                sbU.append(this.screenshotUri);
                sbU.append(", reportName=");
                sbU.append(this.reportName);
                sbU.append(", reportDescription=");
                sbU.append(this.reportDescription);
                sbU.append(", priority=");
                sbU.append(this.priority);
                sbU.append(", feature=");
                sbU.append(this.feature);
                sbU.append(", useScreenshot=");
                sbU.append(this.useScreenshot);
                sbU.append(", error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error) {
                super(null);
                d0.z.d.m.checkNotNullParameter(uri, "screenshotUri");
                this.screenshotUri = uri;
                this.reportName = str;
                this.reportDescription = str2;
                this.priority = num;
                this.feature = feature;
                this.useScreenshot = z2;
                this.error = error;
            }
        }

        /* compiled from: BugReportViewModel.kt */
        public static final /* data */ class SelectFeature extends ViewState {
            private final List<Feature> features;
            private final boolean loadingFeatures;
            private final String query;

            public SelectFeature() {
                this(null, false, null, 7, null);
            }

            public /* synthetic */ SelectFeature(String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? n.emptyList() : list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectFeature copy$default(SelectFeature selectFeature, String str, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectFeature.query;
                }
                if ((i & 2) != 0) {
                    z2 = selectFeature.loadingFeatures;
                }
                if ((i & 4) != 0) {
                    list = selectFeature.features;
                }
                return selectFeature.copy(str, z2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final List<Feature> component3() {
                return this.features;
            }

            public final SelectFeature copy(String query, boolean loadingFeatures, List<Feature> features) {
                d0.z.d.m.checkNotNullParameter(features, "features");
                return new SelectFeature(query, loadingFeatures, features);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectFeature)) {
                    return false;
                }
                SelectFeature selectFeature = (SelectFeature) other;
                return d0.z.d.m.areEqual(this.query, selectFeature.query) && this.loadingFeatures == selectFeature.loadingFeatures && d0.z.d.m.areEqual(this.features, selectFeature.features);
            }

            public final List<Feature> getFeatures() {
                return this.features;
            }

            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final String getQuery() {
                return this.query;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.query;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.loadingFeatures;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                List<Feature> list = this.features;
                return i2 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("SelectFeature(query=");
                sbU.append(this.query);
                sbU.append(", loadingFeatures=");
                sbU.append(this.loadingFeatures);
                sbU.append(", features=");
                return a.L(sbU, this.features, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectFeature(String str, boolean z2, List<Feature> list) {
                super(null);
                d0.z.d.m.checkNotNullParameter(list, "features");
                this.query = str;
                this.loadingFeatures = z2;
                this.features = list;
            }
        }

        /* compiled from: BugReportViewModel.kt */
        public static final /* data */ class Sending extends ViewState {
            private final Sticker sendingSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Sending(Sticker sticker) {
                super(null);
                d0.z.d.m.checkNotNullParameter(sticker, "sendingSticker");
                this.sendingSticker = sticker;
            }

            public static /* synthetic */ Sending copy$default(Sending sending, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = sending.sendingSticker;
                }
                return sending.copy(sticker);
            }

            /* renamed from: component1, reason: from getter */
            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public final Sending copy(Sticker sendingSticker) {
                d0.z.d.m.checkNotNullParameter(sendingSticker, "sendingSticker");
                return new Sending(sendingSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Sending) && d0.z.d.m.areEqual(this.sendingSticker, ((Sending) other).sendingSticker);
                }
                return true;
            }

            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public int hashCode() {
                Sticker sticker = this.sendingSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Sending(sendingSticker=");
                sbU.append(this.sendingSticker);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: BugReportViewModel.kt */
        public static final /* data */ class Success extends ViewState {
            private final Sticker successSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Sticker sticker) {
                super(null);
                d0.z.d.m.checkNotNullParameter(sticker, "successSticker");
                this.successSticker = sticker;
            }

            public static /* synthetic */ Success copy$default(Success success, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = success.successSticker;
                }
                return success.copy(sticker);
            }

            /* renamed from: component1, reason: from getter */
            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public final Success copy(Sticker successSticker) {
                d0.z.d.m.checkNotNullParameter(successSticker, "successSticker");
                return new Success(successSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && d0.z.d.m.areEqual(this.successSticker, ((Success) other).successSticker);
                }
                return true;
            }

            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public int hashCode() {
                Sticker sticker = this.successSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Success(successSticker=");
                sbU.append(this.successSticker);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$dismissAfterDelay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            PublishSubject publishSubjectAccess$getEventSubject$p = BugReportViewModel.access$getEventSubject$p(BugReportViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.CloseReport.INSTANCE);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$loadFeatures$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RestCallState<? extends BugReportConfig>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends BugReportConfig> restCallState) {
            invoke2((RestCallState<BugReportConfig>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<BugReportConfig> restCallState) {
            d0.z.d.m.checkNotNullParameter(restCallState, "it");
            BugReportViewModel.access$setBugReportConfig$p(BugReportViewModel.this, restCallState);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            d0.z.d.m.checkNotNullParameter(downloadState, "it");
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            d0.z.d.m.checkNotNullParameter(downloadState, "it");
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            BugReportViewModel bugReportViewModel = BugReportViewModel.this;
            BugReportViewModel.access$updateViewState(bugReportViewModel, new ViewState.Success(bugReportViewModel.getSuccessSticker()));
            BugReportViewModel.access$dismissAfterDelay(BugReportViewModel.this);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            d0.z.d.m.checkNotNullParameter(error, "error");
            BugReportViewModel.this.showReport(error);
        }
    }

    static {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        sendingStickers = n.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754107634172297306L), companion.getStickers().getStickers().get(751606719611928586L), companion.getStickers().getStickers().get(749049128012742676L), companion.getStickers().getStickers().get(761114619137359892L), companion.getStickers().getStickers().get(783788733987815434L)});
        successStickers = n.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754109076933443614L), companion.getStickers().getStickers().get(751606065447305216L), companion.getStickers().getStickers().get(749053689419006003L), companion.getStickers().getStickers().get(761108384010862602L), companion.getStickers().getStickers().get(783794979704537108L)});
    }

    public /* synthetic */ BugReportViewModel(Uri uri, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$dismissAfterDelay(BugReportViewModel bugReportViewModel) {
        bugReportViewModel.dismissAfterDelay();
    }

    public static final /* synthetic */ RestCallState access$getBugReportConfig$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.bugReportConfig;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.eventSubject;
    }

    public static final /* synthetic */ List access$getGenericFeatureAreas$cp() {
        return genericFeatureAreas;
    }

    public static final /* synthetic */ List access$getSendingStickers$cp() {
        return sendingStickers;
    }

    public static final /* synthetic */ List access$getSuccessStickers$cp() {
        return successStickers;
    }

    public static final /* synthetic */ void access$setBugReportConfig$p(BugReportViewModel bugReportViewModel, RestCallState restCallState) {
        bugReportViewModel.bugReportConfig = restCallState;
    }

    public static final /* synthetic */ void access$updateViewState(BugReportViewModel bugReportViewModel, ViewState viewState) {
        bugReportViewModel.updateViewState(viewState);
    }

    private final void dismissAfterDelay() {
        Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
        d0.z.d.m.checkNotNullExpressionValue(observableD0, "Observable.timer(1500, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    private final List<Feature> filterFeatures(String filter) {
        BugReportConfig bugReportConfigInvoke;
        RestCallState<BugReportConfig> restCallState = this.bugReportConfig;
        List<Feature> listA = (restCallState == null || (bugReportConfigInvoke = restCallState.invoke()) == null) ? null : bugReportConfigInvoke.a();
        if (listA == null) {
            listA = n.emptyList();
        }
        List<Feature> listPlus = u.plus((Collection) listA, (Iterable) genericFeatureAreas);
        if (filter == null) {
            return listPlus;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listPlus) {
            Feature feature = (Feature) obj;
            boolean z2 = true;
            if (!w.contains((CharSequence) feature.getName(), (CharSequence) filter, true) && !w.contains((CharSequence) feature.getSquad(), (CharSequence) filter, true)) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void showReport$default(BugReportViewModel bugReportViewModel, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = null;
        }
        bugReportViewModel.showReport(error);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getReportDescription() {
        return this.reportDescription;
    }

    public final String getReportName() {
        return this.reportName;
    }

    public final RestAPI getRestApi() {
        return this.restApi;
    }

    public final String getScreenshotName() {
        return this.screenshotName;
    }

    public final Uri getScreenshotUri() {
        return this.screenshotUri;
    }

    public final Sticker getSendingSticker() {
        return this.sendingSticker;
    }

    public final boolean getStickersPrefetched() {
        return this.stickersPrefetched;
    }

    public final Sticker getSuccessSticker() {
        return this.successSticker;
    }

    public final boolean getUseScreenshot() {
        return this.useScreenshot;
    }

    public final void loadFeatures() {
        RestCallStateKt.executeRequest(this.restApi.getBugReportConfig(), new AnonymousClass1());
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        d0.z.d.m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void prefetchStickers(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        if (this.stickersPrefetched) {
            return;
        }
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.sendingSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.successSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 62, (Object) null);
        this.stickersPrefetched = true;
    }

    public final void selectFeatureArea(Feature feature) {
        this.feature = feature;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void sendReport(RequestBody screenshotBody) {
        Integer num;
        String str = this.reportName;
        if (str == null || (num = this.priority) == null) {
            return;
        }
        int iIntValue = num.intValue();
        MultipartBody.Part partB = screenshotBody != null ? MultipartBody.Part.b("screenshot", this.screenshotName, screenshotBody) : null;
        updateViewState(new ViewState.Sending(this.sendingSticker));
        RestAPI restAPI = this.restApi;
        String str2 = this.reportDescription;
        Feature feature = this.feature;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(restAPI.sendBugReport(str, str2, iIntValue, feature != null ? feature.getAsanaInboxId() : null, partB), false, 1, null)), BugReportViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final void setFeature(Feature feature) {
        this.feature = feature;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final void setReportDescription(String str) {
        this.reportDescription = str;
    }

    public final void setReportName(String str) {
        this.reportName = str;
    }

    public final void setStickersPrefetched(boolean z2) {
        this.stickersPrefetched = z2;
    }

    public final void setUseScreenshot(boolean z2) {
        this.useScreenshot = z2;
    }

    public final void showFeatureAreas() {
        String str = this.featureSearchQuery;
        updateViewState(new ViewState.SelectFeature(str, this.bugReportConfig instanceof Loading, u.sortedWith(filterFeatures(str), new BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1())));
    }

    public final void showReport(Error error) {
        updateViewState(new ViewState.Report(this.screenshotUri, this.reportName, this.reportDescription, this.priority, this.feature, this.useScreenshot, error));
    }

    @MainThread
    public final void updatePriority(int priority) {
        this.priority = Integer.valueOf(priority);
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportDescription(String description) {
        d0.z.d.m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.reportDescription = description;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportName(String name) {
        d0.z.d.m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.reportName = name;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void useScreenshot(boolean useScreenshot) {
        this.useScreenshot = useScreenshot;
        showReport$default(this, null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel(Uri uri, String str, RestAPI restAPI) {
        super(null, 1, null);
        d0.z.d.m.checkNotNullParameter(uri, "screenshotUri");
        d0.z.d.m.checkNotNullParameter(restAPI, "restApi");
        this.screenshotUri = uri;
        this.screenshotName = str;
        this.restApi = restAPI;
        List<Sticker> list = sendingStickers;
        int iRandom = f.random(n.getIndices(list), c.k);
        this.stickerCharacterIndex = iRandom;
        this.sendingSticker = list.get(iRandom);
        this.successSticker = successStickers.get(iRandom);
        this.useScreenshot = true;
        this.eventSubject = PublishSubject.k0();
        loadFeatures();
    }

    /* renamed from: filterFeatures, reason: collision with other method in class */
    public final void m23filterFeatures(String it) {
        d0.z.d.m.checkNotNullParameter(it, "it");
        this.featureSearchQuery = it;
        showFeatureAreas();
    }
}
