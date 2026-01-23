package com.discord.widgets.notice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p483p.p484a.Alerter;
import p007b.p483p.p484a.Alerter3;
import p007b.p483p.p484a.ViewOnClickListenerC5272b;
import p507d0.p513e0.KClass;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup {
    private static final int DEFAULT_AUTO_DISMISS_PERIOD_SECONDS = 5;
    public static final NoticePopup INSTANCE = new NoticePopup();

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopup$enqueue$1 */
    /* JADX INFO: compiled from: NoticePopup.kt */
    public static final class C90901 extends Lambda implements Function1<View, Unit> {
        public static final C90901 INSTANCE = new C90901();

        public C90901() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
        }
    }

    private NoticePopup() {
    }

    public static final /* synthetic */ void access$cancelCountdown(NoticePopup noticePopup, ValueAnimator valueAnimator) {
        noticePopup.cancelCountdown(valueAnimator);
    }

    public static final /* synthetic */ void access$dismiss(NoticePopup noticePopup, String str) {
        noticePopup.dismiss(str);
    }

    public static final /* synthetic */ ValueAnimator access$getAutoDismissAnimator(NoticePopup noticePopup, Integer num, Function0 function0) {
        return noticePopup.getAutoDismissAnimator(num, function0);
    }

    private final void cancelCountdown(ValueAnimator autoDismissAnimator) {
        if (autoDismissAnimator != null) {
            autoDismissAnimator.cancel();
        }
        if (autoDismissAnimator != null) {
            autoDismissAnimator.end();
        }
    }

    private final void dismiss(String name) {
        ViewGroup viewGroup;
        ViewOnClickListenerC5272b viewOnClickListenerC5272b;
        WeakReference<ViewGroup> weakReference = Alerter3.f14367a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            Intrinsics3.checkNotNullExpressionValue(viewGroup, "it");
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i = 0;
                while (true) {
                    if (viewGroup.getChildAt(i) instanceof ViewOnClickListenerC5272b) {
                        View childAt = viewGroup.getChildAt(i);
                        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                        viewOnClickListenerC5272b = (ViewOnClickListenerC5272b) childAt;
                    } else {
                        viewOnClickListenerC5272b = null;
                    }
                    if (viewOnClickListenerC5272b != null && viewOnClickListenerC5272b.getWindowToken() != null) {
                        ViewCompat.animate(viewOnClickListenerC5272b).alpha(0.0f).withEndAction(new Alerter(viewOnClickListenerC5272b));
                    }
                    if (i == childCount) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), name, 0L, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void enqueue$default(NoticePopup noticePopup, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable, String str2, Drawable drawable2, List list, String str3, Integer num, Drawable drawable3, Integer num2, List list2, Function1 function1, Function1 function12, int i, Object obj) {
        noticePopup.enqueue(str, charSequence, (i & 4) != 0 ? null : charSequence2, charSequence3, (i & 16) != 0 ? null : drawable, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : drawable2, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : drawable3, (i & 2048) != 0 ? 5 : num2, (i & 4096) != 0 ? CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)) : list2, (i & 8192) != 0 ? C90901.INSTANCE : function1, function12);
    }

    private final ValueAnimator getAutoDismissAnimator(Integer autoDismissPeriodSecs, Function0<Unit> onEnd) {
        if (autoDismissPeriodSecs == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(0, 1);
        NoticePopup7 noticePopup7 = new NoticePopup7(onEnd);
        Intrinsics3.checkNotNullExpressionValue(valueAnimatorOfInt, "animator");
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(((long) autoDismissPeriodSecs.intValue()) * 1000);
        valueAnimatorOfInt.addListener(noticePopup7);
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final void enqueue(String noticeName, CharSequence noticeTitle, CharSequence noticeSubtitle, CharSequence noticeBody, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, List<Sticker> noticeStickers, String noticeIconUrl, Integer noticeIconResId, Drawable noticeIconTopRight, Integer noticeAutoDismissPeriodSecs, List<? extends KClass<? extends AppComponent>> validScreens, Function1<? super View, Unit> onClickTopRightIcon, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        Intrinsics3.checkNotNullParameter(validScreens, "validScreens");
        Intrinsics3.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 1, false, validScreens, 1000L, false, 0L, new NoticePopup2(onClick, noticeName, noticeAutoDismissPeriodSecs, noticeIconUrl, noticeIconResId, noticeBodyImageUrl, noticeBodyImageDrawable, noticeBodyBackgroundDrawable, noticeTitle, noticeSubtitle, noticeBody, noticeIconTopRight, noticeStickers, onClickTopRightIcon), 150, null));
    }
}
