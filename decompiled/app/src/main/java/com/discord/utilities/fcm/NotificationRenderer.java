package com.discord.utilities.fcm;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.notice.NoticePopup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.NeverObservableHolder;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorOnErrorResumeNextViaFunction2;
import p637j0.p642l.p643a.OperatorOnErrorResumeNextViaFunction4;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: NotificationRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRenderer {
    public static final NotificationRenderer INSTANCE = new NotificationRenderer();
    private static final String NON_ADAPTIVE_NOTIFICATION_ICON = "com.discord.utilities.NON_ADAPTIVE_NOTIFICATION_ICON ";
    private static final long NOTIFICATION_AUTO_DISMISS = 3000;
    private static final long NOTIFICATION_ICON_FETCH_DELAY_MS = 250;
    private static final int NOTIFICATION_LIGHT_PERIOD = 1500;

    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class NotificationDisplaySubscriptionManager {
        public static final NotificationDisplaySubscriptionManager INSTANCE = new NotificationDisplaySubscriptionManager();
        private static final HashMap<Integer, Subscription> notificationDisplaySubscriptions = new HashMap<>();

        private NotificationDisplaySubscriptionManager() {
        }

        public final void add(int displayPayloadId, Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            HashMap<Integer, Subscription> map = notificationDisplaySubscriptions;
            synchronized (map) {
                INSTANCE.cancel(displayPayloadId);
                map.put(Integer.valueOf(displayPayloadId), subscription);
            }
        }

        public final void cancel(int displayPayloadId) {
            HashMap<Integer, Subscription> map = notificationDisplaySubscriptions;
            synchronized (map) {
                Subscription subscriptionRemove = map.remove(Integer.valueOf(displayPayloadId));
                if (subscriptionRemove != null) {
                    subscriptionRemove.unsubscribe();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$clear$1 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class C67481 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67481(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            Context context = this.$context;
            if (context != null) {
                NotificationManagerCompat.from(context).cancel(i);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$displayAndUpdateCache$4 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final /* synthetic */ class C67494 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public C67494(CompositeSubscription compositeSubscription) {
            super(1, compositeSubscription, CompositeSubscription.class, "add", "add(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((CompositeSubscription) this.receiver).m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$displayAndUpdateCache$5 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class C67505 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ NotificationData.DisplayPayload $displayPayload;
        public final /* synthetic */ NotificationData $notification;
        public final /* synthetic */ NotificationCompat.Builder $notificationBuilder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67505(Context context, NotificationData.DisplayPayload displayPayload, NotificationCompat.Builder builder, NotificationData notificationData) {
            super(1);
            this.$context = context;
            this.$displayPayload = displayPayload;
            this.$notificationBuilder = builder;
            this.$notification = notificationData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
            NotificationRenderer.access$displayNotification(notificationRenderer, this.$context, this.$displayPayload.getId(), this.$notificationBuilder);
            NotificationRenderer.pushShortcut$default(notificationRenderer, this.$context, this.$notification, this.$notificationBuilder, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$displayAndUpdateCache$6 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final /* synthetic */ class C67516 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public C67516(CompositeSubscription compositeSubscription) {
            super(1, compositeSubscription, CompositeSubscription.class, "add", "add(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((CompositeSubscription) this.receiver).m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$displayAndUpdateCache$7 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class C67527 extends Lambda implements Function1<MGImagesBitmap.CloseableBitmaps, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ NotificationData.DisplayPayload $displayPayload;
        public final /* synthetic */ List $displayPayloadExtras;
        public final /* synthetic */ NotificationData $notification;
        public final /* synthetic */ NotificationCompat.Builder $notificationBuilder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67527(NotificationData notificationData, NotificationCompat.Builder builder, List list, Context context, NotificationData.DisplayPayload displayPayload) {
            super(1);
            this.$notification = notificationData;
            this.$notificationBuilder = builder;
            this.$displayPayloadExtras = list;
            this.$context = context;
            this.$displayPayload = displayPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MGImagesBitmap.CloseableBitmaps closeableBitmaps) throws IOException {
            invoke2(closeableBitmaps);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) throws IOException {
            IconCompat iconCompatCreateWithBitmap;
            Intrinsics3.checkNotNullParameter(closeableBitmaps, "bitmapsForIconUris");
            try {
                Bitmap bitmap = (Bitmap) closeableBitmaps.get(NotificationRenderer.NON_ADAPTIVE_NOTIFICATION_ICON);
                if (bitmap == null) {
                    bitmap = (Bitmap) closeableBitmaps.get((Object) this.$notification.getIconUrl());
                }
                if (bitmap != null) {
                    this.$notificationBuilder.setLargeIcon(bitmap);
                }
                if (!this.$displayPayloadExtras.isEmpty()) {
                    this.$notificationBuilder.setNumber(this.$displayPayloadExtras.size());
                    NotificationCompat.Builder builder = this.$notificationBuilder;
                    NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
                    builder.setStyle(NotificationRenderer.access$getMessageStyle(notificationRenderer, this.$context, this.$notification, this.$displayPayloadExtras, closeableBitmaps));
                    Bitmap bitmap2 = (Bitmap) closeableBitmaps.get((Object) this.$notification.getIconUrl());
                    if (bitmap2 == null || (iconCompatCreateWithBitmap = IconCompat.createWithAdaptiveBitmap(bitmap2)) == null) {
                        Bitmap bitmap3 = (Bitmap) closeableBitmaps.get(NotificationRenderer.NON_ADAPTIVE_NOTIFICATION_ICON);
                        iconCompatCreateWithBitmap = bitmap3 != null ? IconCompat.createWithBitmap(bitmap3) : null;
                    }
                    NotificationRenderer.access$pushShortcut(notificationRenderer, this.$context, this.$notification, this.$notificationBuilder, iconCompatCreateWithBitmap);
                }
                NotificationRenderer.access$displayNotification(NotificationRenderer.INSTANCE, this.$context, this.$displayPayload.getId(), this.$notificationBuilder);
                Closeable.closeFinally(closeableBitmaps, null);
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$displayInApp$1 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class C67531 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ NotificationData $notificationData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67531(NotificationData notificationData, Context context) {
            super(1);
            this.$notificationData = notificationData;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) throws PendingIntent.CanceledException {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) throws PendingIntent.CanceledException {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$notificationData.getContentIntentInApp(this.$context).send();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$loadNotificationBitmaps$1 */
    /* JADX INFO: compiled from: NotificationRenderer.kt */
    public static final class C67541<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ NotificationData $notification;

        /* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationRenderer$loadNotificationBitmaps$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: NotificationRenderer.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Bitmap, MGImagesBitmap.CloseableBitmaps> {
            public final /* synthetic */ MGImagesBitmap.CloseableBitmaps $adaptive;

            public AnonymousClass1(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                this.$adaptive = closeableBitmaps;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Bitmap bitmap) {
                return call2(bitmap);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final MGImagesBitmap.CloseableBitmaps call2(Bitmap bitmap) {
                return this.$adaptive.plus(new MGImagesBitmap.CloseableBitmaps(MapsJVM.mapOf(Tuples.m10073to(NotificationRenderer.NON_ADAPTIVE_NOTIFICATION_ICON, bitmap)), false, 2, null));
            }
        }

        public C67541(NotificationData notificationData) {
            this.$notification = notificationData;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            return call2(closeableBitmaps);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            if (Intrinsics3.areEqual(this.$notification.getType(), NotificationData.TYPE_GENERIC_PUSH_NOTIFICATION_SENT)) {
                if (this.$notification.getIconUrl().length() == 0) {
                    return new ScalarSynchronousObservable(closeableBitmaps);
                }
            }
            return MGImagesBitmap.INSTANCE.getBitmap(this.$notification.getIconUrl(), true).m11083G(new AnonymousClass1(closeableBitmaps));
        }
    }

    private NotificationRenderer() {
    }

    public static final /* synthetic */ void access$displayNotification(NotificationRenderer notificationRenderer, Context context, int i, NotificationCompat.Builder builder) {
        notificationRenderer.displayNotification(context, i, builder);
    }

    public static final /* synthetic */ NotificationCompat.MessagingStyle access$getMessageStyle(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, List list, Map map) {
        return notificationRenderer.getMessageStyle(context, notificationData, list, map);
    }

    public static final /* synthetic */ void access$pushShortcut(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, NotificationCompat.Builder builder, IconCompat iconCompat) {
        notificationRenderer.pushShortcut(context, notificationData, builder, iconCompat);
    }

    private final void autoDismissNotification(Context context, int notificationId) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, NotificationActions.INSTANCE.cancel(context, notificationId), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(2, SystemClock.elapsedRealtime() + NOTIFICATION_AUTO_DISMISS, broadcast);
    }

    private final void displayAndUpdateCache(Context context, NotificationData notification, NotificationClient.SettingsV2 settings) {
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, notification.getNotificationChannelId()).setAutoCancel(true).setOnlyAlertOnce(true).setSmallIcon(notification.getSmallIcon()).setColor(ColorCompat.getThemedColor(context, C5419R.attr.color_brand_500)).setCategory(notification.getNotificationCategory()).setContentTitle(notification.getTitle(context)).setContentText(notification.getContent(context)).setDefaults(getNotificationDefaults(settings.isDisableSound(), settings.isDisableVibrate())).setDeleteIntent(notification.getDeleteIntent(context)).setContentIntent(notification.getContentIntent(context));
        Intrinsics3.checkNotNullExpressionValue(contentIntent, "NotificationCompat.Build…etContentIntent(context))");
        contentIntent.setGroup(notification.getGroupKey());
        NotificationData.DisplayPayload andUpdate = NotificationCache.INSTANCE.getAndUpdate(notification);
        List<NotificationData> extras = andUpdate.getExtras();
        PendingIntent fullScreenIntent = notification.getFullScreenIntent(context);
        if (fullScreenIntent != null) {
            contentIntent.setFullScreenIntent(fullScreenIntent, true);
            contentIntent.setVisibility(1);
        }
        if (!extras.isEmpty()) {
            contentIntent.setNumber(extras.size());
            contentIntent.setStyle(getMessageStyle(context, notification, extras, new MGImagesBitmap.CloseableBitmaps(Maps6.emptyMap(), false, 2, null)));
        }
        if (notification.getShouldUseBigText()) {
            contentIntent.setStyle(new NotificationCompat.BigTextStyle().bigText(notification.getContent(context)));
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            contentIntent.setPriority(notification.getNotificationPriority()).setVibrate(new long[]{0});
            if (!settings.isDisableBlink()) {
                contentIntent.setLights(ColorCompat.getThemedColor(context, C5419R.attr.color_brand), NOTIFICATION_LIGHT_PERIOD, NOTIFICATION_LIGHT_PERIOD);
            }
            Uri notificationSound = notification.getNotificationSound(context);
            if (notificationSound != null) {
                Uri uri = settings.isDisableSound() ^ true ? notificationSound : null;
                if (uri != null) {
                    contentIntent.setSound(uri).setDefaults(INSTANCE.getNotificationDefaults(settings.isDisableSound(), settings.isDisableVibrate()) & (-2));
                }
            }
        }
        if (i >= 24) {
            for (NotificationCompat.Action action : Collections2.listOf((Object[]) new NotificationCompat.Action[]{notification.getMarkAsReadAction(context), notification.getDirectReplyAction(context, settings.getSendBlockedChannels()), notification.getTimedMute(context, ClockFactory.get(), extras.size()), notification.getCallAction(context, false), notification.getCallAction(context, true)})) {
                if (action != null) {
                    contentIntent.addAction(action);
                }
            }
        }
        NotificationDisplaySubscriptionManager notificationDisplaySubscriptionManager = NotificationDisplaySubscriptionManager.INSTANCE;
        notificationDisplaySubscriptionManager.cancel(andUpdate.getId());
        Tuples2<Integer, Observable<MGImagesBitmap.CloseableBitmaps>> tuples2LoadNotificationBitmaps = loadNotificationBitmaps(andUpdate, notification);
        int iIntValue = tuples2LoadNotificationBitmaps.component1().intValue();
        Observable<MGImagesBitmap.CloseableBitmaps> observableComponent2 = tuples2LoadNotificationBitmaps.component2();
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        Observable<Long> observableM11102a0 = Observable.m11068d0(NOTIFICATION_ICON_FETCH_DELAY_MS, TimeUnit.MILLISECONDS).m11102a0(Observable.m11074h0(new OnSubscribeLift(observableComponent2.f27640j, new OperatorOnErrorResumeNextViaFunction4(new OperatorOnErrorResumeNextViaFunction2(NeverObservableHolder.f26760k)))));
        Intrinsics3.checkNotNullExpressionValue(observableM11102a0, "Observable\n        .time…Next(Observable.never()))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11102a0), (Context) null, "Unable to display notification, timeout.", new C67494(compositeSubscription), new C67505(context, andUpdate, contentIntent, notification), (Function1) null, (Function0) null, (Function0) null, 112, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableComponent2), (Context) null, outline.m873r("Unable to display notification multi-fetch ", iIntValue, " bitmaps."), new C67516(compositeSubscription), new C67527(notification, contentIntent, extras, context, andUpdate), (Function1) null, (Function0) null, (Function0) null, 112, (Object) null);
        notificationDisplaySubscriptionManager.add(andUpdate.getId(), compositeSubscription);
    }

    private final void displayNotification(Context context, int payloadId, NotificationCompat.Builder notificationBuilder) {
        try {
            NotificationManagerCompat.from(context).notify(payloadId, notificationBuilder.build());
        } catch (IllegalStateException e) {
            Logger.e$default(AppLog.f14950g, "NotifyError", e, null, 4, null);
        }
    }

    private final NotificationCompat.MessagingStyle getMessageStyle(Context context, NotificationData notification, List<NotificationData> lines, Map<String, Bitmap> bitmapsForIconUris) {
        Person personBuild = new Person.Builder().setName(context.getString(C5419R.string.f14778me)).setKey("me").build();
        Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …ey(\"me\")\n        .build()");
        NotificationCompat.MessagingStyle groupConversation = new NotificationCompat.MessagingStyle(personBuild).setConversationTitle(notification.getConversationTitle(context)).setGroupConversation(notification.getIsGroupConversation());
        Intrinsics3.checkNotNullExpressionValue(groupConversation, "NotificationCompat.Messa…tion.isGroupConversation)");
        for (NotificationData notificationData : lines) {
            Bitmap bitmap = bitmapsForIconUris.get(notificationData.getIconUrlForAvatar());
            IconCompat iconCompatCreateWithAdaptiveBitmap = bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null;
            Person personBuild2 = notificationData.getSender(context).toBuilder().setIcon(iconCompatCreateWithAdaptiveBitmap).build();
            Intrinsics3.checkNotNullExpressionValue(personBuild2, "person.toBuilder()\n     …(icon)\n          .build()");
            groupConversation.addMessage(notificationData.getContent(context), notificationData.getMessageIdTimestamp() + ((long) (iconCompatCreateWithAdaptiveBitmap == null ? 0 : 1)), personBuild2);
        }
        return groupConversation;
    }

    private final int getNotificationDefaults(boolean disableSound, boolean disableVibrate) {
        int i = !disableSound ? 1 : 0;
        return !disableVibrate ? i | 2 : i;
    }

    private final Tuples2<Integer, Observable<MGImagesBitmap.CloseableBitmaps>> loadNotificationBitmaps(NotificationData.DisplayPayload displayPayload, NotificationData notification) {
        List<NotificationData> extras = displayPayload.getExtras();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = extras.iterator();
        while (it.hasNext()) {
            String iconUrlForAvatar = ((NotificationData) it.next()).getIconUrlForAvatar();
            if (iconUrlForAvatar != null) {
                arrayList.add(iconUrlForAvatar);
            }
        }
        List listPlus = _Collections.plus((Collection<? extends String>) arrayList, notification.getIconUrl());
        return Tuples.m10073to(Integer.valueOf(listPlus.size() + 1), ShareUtils.INSTANCE.loadAdaptiveBitmaps(_Collections.asSequence(listPlus)).m11082A(new C67541(notification)));
    }

    private final void pushShortcut(Context context, NotificationData notification, NotificationCompat.Builder notificationBuilder, IconCompat icon) {
        ShareUtils shareUtils = ShareUtils.INSTANCE;
        shareUtils.addShortcut(context, ShareUtils.toShortcutInfo$default(shareUtils, context, notification.getChannelId(), notification.getTitle(context), null, icon, null, 0, 104, null), notificationBuilder);
    }

    public static /* synthetic */ void pushShortcut$default(NotificationRenderer notificationRenderer, Context context, NotificationData notificationData, NotificationCompat.Builder builder, IconCompat iconCompat, int i, Object obj) {
        if ((i & 8) != 0) {
            iconCompat = null;
        }
        notificationRenderer.pushShortcut(context, notificationData, builder, iconCompat);
    }

    public final void clear(Context context, long channelId, boolean isAckRequest) {
        NotificationCache.INSTANCE.remove(channelId, isAckRequest, new C67481(context));
    }

    public final void display(Context context, NotificationData notificationData, NotificationClient.SettingsV2 settings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(notificationData, "notificationData");
        Intrinsics3.checkNotNullParameter(settings, "settings");
        try {
            displayAndUpdateCache(context, notificationData, settings);
        } catch (Exception e) {
            Logger.e$default(AppLog.f14950g, "Unable to display notification.", e, null, 4, null);
        }
    }

    public final void displayInApp(Context context, NotificationData notificationData) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(notificationData, "notificationData");
        if (notificationData.canDisplayInApp()) {
            CharSequence title = notificationData.getTitle(context);
            CharSequence content = notificationData.getContent(context);
            if (content == null) {
                content = "";
            }
            CharSequence charSequence = content;
            if (StringsJVM.isBlank(title) && StringsJVM.isBlank(charSequence)) {
                return;
            }
            NoticePopup noticePopup = NoticePopup.INSTANCE;
            StringBuilder sbM833U = outline.m833U("InAppNotif#");
            sbM833U.append(ClockFactory.get().currentTimeMillis());
            NoticePopup.enqueue$default(noticePopup, sbM833U.toString(), title, null, charSequence, null, null, null, null, notificationData.getIconUrl(), null, null, null, null, null, new C67531(notificationData, context), 16116, null);
        }
    }

    public final void displaySent(Context context, long channelId, CharSequence channelName, boolean success, int notificationId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        int i = success ? C5419R.string.notification_reply_success : C5419R.string.notification_reply_failed;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, NotificationActions.INSTANCE.delete(context, channelId), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Intent intentSelectChannel$default = IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null);
        intentSelectChannel$default.setClass(context, AppActivity.Main.class);
        Notification notificationBuild = new NotificationCompat.Builder(context, NotificationClient.NOTIF_CHANNEL_MESSAGES).setAutoCancel(true).setSmallIcon(C5419R.drawable.ic_notification_message_24dp).setCategory(NotificationCompat.CATEGORY_MESSAGE).setContentText(FormatUtils.m216h(context, i, new Object[]{channelName}, null, 4)).setDeleteIntent(broadcast).setContentIntent(PendingIntent.getActivity(context, 0, intentSelectChannel$default, PendingIntentExtensions.immutablePendingIntentFlag(134217728))).build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…ent)\n            .build()");
        NotificationManagerCompat.from(context).notify(notificationId, notificationBuild);
        autoDismissNotification(context, notificationId);
    }

    @RequiresApi(26)
    public final void initNotificationChannels(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        NotificationChannel notificationChannel = new NotificationChannel(NotificationClient.NOTIF_CHANNEL_CALLS, context.getString(C5419R.string.call), 4);
        NotificationChannel notificationChannel2 = new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS, context.getString(C5419R.string.voice), 2);
        List<NotificationChannel> listListOf = Collections2.listOf((Object[]) new NotificationChannel[]{notificationChannel, notificationChannel2, new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MESSAGES, context.getString(C5419R.string.messages), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_MESSAGES_DIRECT, context.getString(C5419R.string.direct_messages), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_FORUM_POST_CREATE, context.getString(C5419R.string.forum_channel_thread_created_push_description_mobile), 4), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_SOCIAL, context.getString(C5419R.string.friends), 2), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_GAME_DETECTION, context.getString(C5419R.string.game_detection_service), 1), new NotificationChannel(NotificationClient.NOTIF_CHANNEL_STAGE_START, context.getString(C5419R.string.stage_start_notification_category), 4), new NotificationChannel(NotificationClient.NOTIF_GUILD_SCHEDULED_EVENT_START, context.getString(C5419R.string.guild_scheduled_event_live), 4), new NotificationChannel(NotificationClient.NOTIF_GENERAL, context.getString(C5419R.string.other), 2), new NotificationChannel(NotificationClient.NOTIF_GENERAL_HIGH_PRIO, context.getString(C5419R.string.other_high_priority), 4)});
        for (NotificationChannel notificationChannel3 : listListOf) {
            notificationChannel3.setShowBadge(true);
            notificationChannel3.enableVibration(true);
            notificationChannel3.enableLights(true);
            notificationChannel3.setLightColor(ColorCompat.getThemedColor(context, C5419R.attr.color_brand));
        }
        notificationChannel.setDescription(context.getString(C5419R.string.call));
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        notificationChannel.setShowBadge(false);
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        sb.append(context.getPackageName() + MentionUtils.SLASH_CHAR + AppSound.INSTANCE.getSOUND_CALL_RINGING().getResId());
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …)\n            .toString()");
        notificationChannel.setSound(Uri.parse(string), new AudioAttributes.Builder().setUsage(7).setContentType(2).build());
        notificationChannel2.setShowBadge(false);
        notificationChannel2.enableVibration(false);
        Object systemService = context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannels(listListOf);
    }
}
