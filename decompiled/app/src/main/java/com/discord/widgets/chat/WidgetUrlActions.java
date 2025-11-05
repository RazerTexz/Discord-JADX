package com.discord.widgets.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUrlActionsBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.search.results.WidgetSearchResults;
import d0.e0.c;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUrlActions.kt */
/* loaded from: classes2.dex */
public final class WidgetUrlActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUrlActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrlActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_URL = "INTENT_URL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: url$delegate, reason: from kotlin metadata */
    private final Lazy url;

    /* compiled from: WidgetUrlActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(FragmentManager fragmentManager, String url) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(url, "url");
            WidgetUrlActions widgetUrlActions = new WidgetUrlActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetUrlActions.INTENT_URL, url);
            widgetUrlActions.setArguments(bundle);
            widgetUrlActions.show(fragmentManager, WidgetUrlActions.class.getName());
        }

        public final void requestNotice(String url) {
            m.checkNotNullParameter(url, "url");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(url, null, 0L, 0, false, n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetHome.class), a0.getOrCreateKotlinClass(WidgetSearchResults.class)}), 0L, false, 0L, new WidgetUrlActions$Companion$requestNotice$notice$1(url), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUrlActions.kt */
    /* renamed from: com.discord.widgets.chat.WidgetUrlActions$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a.d.m.c(a.x(view, "it", "it.context"), WidgetUrlActions.access$getUrl$p(WidgetUrlActions.this), 0, 4);
            WidgetUrlActions.this.dismiss();
        }
    }

    /* compiled from: WidgetUrlActions.kt */
    /* renamed from: com.discord.widgets.chat.WidgetUrlActions$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), WidgetUrlActions.access$getUrl$p(WidgetUrlActions.this), false, false, null, 28, null);
            WidgetUrlActions.this.dismiss();
        }
    }

    /* compiled from: WidgetUrlActions.kt */
    /* renamed from: com.discord.widgets.chat.WidgetUrlActions$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetUrlActions.this.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String strAccess$getUrl$p = WidgetUrlActions.access$getUrl$p(WidgetUrlActions.this);
            String string = WidgetUrlActions.this.getString(R.string.form_label_send_to);
            m.checkNotNullExpressionValue(string, "getString(R.string.form_label_send_to)");
            IntentUtils.performChooserSendIntent(contextRequireContext, strAccess$getUrl$p, string);
            WidgetUrlActions.this.dismiss();
        }
    }

    public WidgetUrlActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUrlActions$binding$2.INSTANCE, null, 2, null);
        this.url = g.lazy(new WidgetUrlActions$url$2(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetUrlActions widgetUrlActions) {
        return widgetUrlActions.getArgumentsOrDefault();
    }

    public static final /* synthetic */ String access$getUrl$p(WidgetUrlActions widgetUrlActions) {
        return widgetUrlActions.getUrl();
    }

    private final WidgetUrlActionsBinding getBinding() {
        return (WidgetUrlActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getUrl() {
        return (String) this.url.getValue();
    }

    public static final void launch(FragmentManager fragmentManager, String str) {
        INSTANCE.launch(fragmentManager, str);
    }

    public static final void requestNotice(String str) {
        INSTANCE.requestNotice(str);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_url_actions;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), getUrl(), 0L, 2, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.dialogUrlActionsUrl");
        ViewExtensions.setTextAndVisibilityBy(textView, getUrl());
        getBinding().f2678b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().d.setOnClickListener(new AnonymousClass3());
    }
}
