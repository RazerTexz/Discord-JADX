package com.discord.widgets.notice;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxOverlayBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.WidgetSettingsVoice;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetNoticeNuxOverlay.kt */
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNoticeNuxOverlay.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxOverlayBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTICE_NAME = "NUX/Overlay";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetNoticeNuxOverlay.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue() {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetNoticeNuxOverlay.NOTICE_NAME, null, 0L, 0, true, null, 0L, false, 0L, WidgetNoticeNuxOverlay$Companion$enqueue$notice$1.INSTANCE, 486, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNoticeNuxOverlay.kt */
    /* renamed from: com.discord.widgets.notice.WidgetNoticeNuxOverlay$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsVoice.INSTANCE.launch(a.x(view, "it", "it.context"), Integer.valueOf(R.id.settings_voice_overlay_toggle), true);
            WidgetNoticeNuxOverlay.this.dismiss();
        }
    }

    /* compiled from: WidgetNoticeNuxOverlay.kt */
    /* renamed from: com.discord.widgets.notice.WidgetNoticeNuxOverlay$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(false);
            WidgetNoticeNuxOverlay.this.dismiss();
        }
    }

    public WidgetNoticeNuxOverlay() {
        super(R.layout.widget_notice_nux_overlay);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeNuxOverlay$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxOverlayBinding getBinding() {
        return (WidgetNoticeNuxOverlayBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.INSTANCE.getNotices().markDialogSeen(NOTICE_NAME);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2501b.setOnClickListener(new AnonymousClass2());
    }
}
