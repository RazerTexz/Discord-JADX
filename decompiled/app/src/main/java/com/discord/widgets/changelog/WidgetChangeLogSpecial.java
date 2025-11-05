package com.discord.widgets.changelog;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.d.j;
import b.d.b.a.a;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogSpecialBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.webrtc.MediaStreamTrack;

/* compiled from: WidgetChangeLogSpecial.kt */
/* loaded from: classes2.dex */
public final class WidgetChangeLogSpecial extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChangeLogSpecial.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BODY = "INTENT_EXTRA_BODY";
    private static final String INTENT_EXTRA_EXIT_STYLE = "INTENT_EXTRA_EXIT_STYLE";
    private static final String INTENT_EXTRA_HIDE_VIDEO = "INTENT_EXTRA_HIDE_VIDEO";
    private static final String INTENT_EXTRA_REVISION = "INTENT_EXTRA_REVISION";
    private static final String INTENT_EXTRA_VERSION = "INTENT_EXTRA_VERSION";
    private static final String INTENT_EXTRA_VIDEO = "INTENT_EXTRA_VIDEO";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private int maxScrolledPercent;
    private long openedTimestamp;
    private final WidgetChangeLogSpecial$thumbnailControllerListener$1 thumbnailControllerListener;
    private AbstractDraweeController<Object, Object> thumbnailDraweeController;

    /* compiled from: WidgetChangeLogSpecial.kt */
    public static final class Companion {

        /* compiled from: WidgetChangeLogSpecial.kt */
        public enum ExitStyle {
            BACK,
            CLOSE
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, String str, String str2, String str3, String str4, ExitStyle exitStyle, boolean z2, int i, Object obj) {
            companion.launch(context, str, str2, str3, str4, (i & 32) != 0 ? ExitStyle.CLOSE : exitStyle, (i & 64) != 0 ? false : z2);
        }

        public final void launch(Context context, String version, String revision, String video, String body, ExitStyle exitStyle, boolean hideVideo) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(version, "version");
            m.checkNotNullParameter(revision, "revision");
            m.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
            m.checkNotNullParameter(body, "body");
            m.checkNotNullParameter(exitStyle, "exitStyle");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetChangeLogSpecial.INTENT_EXTRA_EXIT_STYLE, exitStyle);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_VERSION, version);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_REVISION, revision);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_VIDEO, video);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_BODY, body);
            bundle.putBoolean(WidgetChangeLogSpecial.INTENT_EXTRA_HIDE_VIDEO, hideVideo);
            j.d(context, WidgetChangeLogSpecial.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$1, reason: invalid class name */
    public static final class AnonymousClass1 implements MediaPlayer.OnCompletionListener {
        public AnonymousClass1() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            WidgetChangeLogSpecial.access$showVideoOverlay(WidgetChangeLogSpecial.this);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i;
            m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            if (videoView.isPlaying()) {
                WidgetChangeLogSpecial.access$showVideoOverlay(WidgetChangeLogSpecial.this);
                WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.pause();
            } else {
                WidgetChangeLogSpecial.access$hideVideoOverlay(WidgetChangeLogSpecial.this);
                WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.start();
            }
            WidgetChangeLogSpecial.track$default(WidgetChangeLogSpecial.this, "change_log_video_interacted", null, false, 2, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$3, reason: invalid class name */
    public static final class AnonymousClass3 implements MediaPlayer.OnPreparedListener {
        public AnonymousClass3() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            m.checkNotNullParameter(mediaPlayer, "mp");
            mediaPlayer.start();
            mediaPlayer.pause();
            VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i;
            m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            videoView.getLayoutParams().height = -2;
            WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.requestLayout();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$hideVideoOverlay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function3<Context, String, String, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(str, "url");
            WidgetChangeLogSpecial.track$default(WidgetChangeLogSpecial.this, "change_log_cta_clicked", g0.mapOf(d0.o.to("cta_type", "inline_link")), false, 4, null);
            UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeLogSpecial.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeLogSpecial.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLogSpecial.this.requireContext(), f.a.a(360056891113L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements NestedScrollView.OnScrollChangeListener {
        public AnonymousClass5() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            WidgetChangeLogSpecial widgetChangeLogSpecial = WidgetChangeLogSpecial.this;
            int iAccess$getMaxScrolledPercent$p = WidgetChangeLogSpecial.access$getMaxScrolledPercent$p(widgetChangeLogSpecial);
            NestedScrollView nestedScrollView2 = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).g;
            m.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogSpecialScrollview");
            int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
            NestedScrollView nestedScrollView3 = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).g;
            m.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogSpecialScrollview");
            WidgetChangeLogSpecial.access$setMaxScrolledPercent$p(widgetChangeLogSpecial, d0.d0.f.coerceAtLeast(iAccess$getMaxScrolledPercent$p, (i2 * 100) / d0.d0.f.coerceAtLeast(height - nestedScrollView3.getHeight(), 1)));
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$showVideoOverlay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$showVideoOverlay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetChangeLogSpecial() {
        super(R.layout.widget_change_log_special);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChangeLogSpecial$binding$2.INSTANCE, new WidgetChangeLogSpecial$binding$3(this));
        this.thumbnailControllerListener = new WidgetChangeLogSpecial$thumbnailControllerListener$1(this);
    }

    public static final /* synthetic */ WidgetChangeLogSpecialBinding access$getBinding$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.getBinding();
    }

    public static final /* synthetic */ int access$getMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.maxScrolledPercent;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChangeLogSpecial widgetChangeLogSpecial, WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        widgetChangeLogSpecial.onViewBindingDestroy(widgetChangeLogSpecialBinding);
    }

    public static final /* synthetic */ void access$setMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial, int i) {
        widgetChangeLogSpecial.maxScrolledPercent = i;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) {
        boolean zEndsWith$default = t.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().j;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().i.setVideoPath(videoUrl);
            getBinding().i.setOnCompletionListener(new AnonymousClass1());
            getBinding().i.setOnClickListener(new AnonymousClass2());
            getBinding().i.setOnPreparedListener(new AnonymousClass3());
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        d dVarA = b.a();
        SimpleDraweeView simpleDraweeView3 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        dVarA.n = simpleDraweeView3.getController();
        d dVarG = dVarA.g(videoUrl);
        dVarG.m = false;
        dVarG.k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = dVarG.a();
        SimpleDraweeView simpleDraweeView4 = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().h.requestLayout();
    }

    private final WidgetChangeLogSpecialBinding getBinding() {
        return (WidgetChangeLogSpecialBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDateString(Context context) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        try {
            Date date = new SimpleDateFormat(TimeUtils.UTCFormat.SHORT).parse(stringExtra);
            if (date == null) {
                date = new Date();
            }
            return " " + DateFormat.getMediumDateFormat(context).format(date) + " ";
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().j, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4, Companion.ExitStyle exitStyle, boolean z2) {
        INSTANCE.launch(context, str, str2, str3, str4, exitStyle, z2);
    }

    private final void onViewBindingDestroy(WidgetChangeLogSpecialBinding binding) {
        binding.i.setOnPreparedListener(null);
        binding.i.setOnCompletionListener(null);
        AbstractDraweeController<Object, Object> abstractDraweeController = this.thumbnailDraweeController;
        if (abstractDraweeController != null) {
            abstractDraweeController.A(this.thumbnailControllerListener);
        }
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().j, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    private final void track(String event, Map<String, ? extends Object> properties, boolean includeStats) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_REVISION);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_revision);
        }
        m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…g.change_log_md_revision)");
        HashMap map = new HashMap();
        if (includeStats) {
            map.put("seconds_open", Long.valueOf((ClockFactory.get().currentTimeMillis() - this.openedTimestamp) / 1000));
            map.put("max_scrolled_percentage", Integer.valueOf(this.maxScrolledPercent));
        }
        AnalyticsTracker.INSTANCE.changeLogEvent(event, stringExtra, stringExtra2, h0.plus(properties, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(WidgetChangeLogSpecial widgetChangeLogSpecial, String str, Map map, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        widgetChangeLogSpecial.track(str, map, z2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        StoreStream.INSTANCE.getChangeLog().markSeen(stringExtra);
        track$default(this, "change_log_closed", null, false, 6, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoView videoView = getBinding().i;
        m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().i.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_body);
        }
        m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_body)");
        if (getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_EXIT_STYLE) == Companion.ExitStyle.BACK) {
            ImageButton imageButton = getBinding().e;
            m.checkNotNullExpressionValue(imageButton, "binding.changeLogSpecialClose");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = getBinding().c;
            m.checkNotNullExpressionValue(imageButton2, "binding.changeLogSpecialBack");
            imageButton2.setVisibility(0);
        }
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.changeLogSpecialDate");
        textView.setText(getDateString(requireContext()));
        getBinding().f2254b.setDraweeSpanStringBuilder(ChangeLogParser.INSTANCE.parse(requireContext(), stringExtra, true, new AnonymousClass1()));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_video);
        }
        m.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().e.setOnClickListener(new AnonymousClass3());
        LinkifiedTextView linkifiedTextView = getBinding().f2254b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.changeLogBody");
        b.a.k.b.n(linkifiedTextView, R.string.changelog_stickers_cta_body, new Object[0], null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2254b;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.changeLogBody");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().d.setOnClickListener(new AnonymousClass4());
        if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_HIDE_VIDEO, false)) {
            VideoView videoView = getBinding().i;
            m.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            videoView.setVisibility(8);
            CardView cardView = getBinding().k;
            m.checkNotNullExpressionValue(cardView, "binding.changelogSpecialHeaderContainer");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, DimenUtils.dpToPixels(16));
        }
        getBinding().g.setOnScrollChangeListener(new AnonymousClass5());
    }
}
