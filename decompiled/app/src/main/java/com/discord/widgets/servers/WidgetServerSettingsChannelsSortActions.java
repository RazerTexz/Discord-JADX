package com.discord.widgets.servers;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsSortActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsChannelsSortActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super Integer, Unit> sortTypeSelectedListener;

    /* compiled from: WidgetServerSettingsChannelsSortActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Function1<? super Integer, Unit> sortTypeSelectedListener) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sortTypeSelectedListener, "sortTypeSelectedListener");
            WidgetServerSettingsChannelsSortActions widgetServerSettingsChannelsSortActions = new WidgetServerSettingsChannelsSortActions();
            widgetServerSettingsChannelsSortActions.setSortTypeSelectedListener(sortTypeSelectedListener);
            widgetServerSettingsChannelsSortActions.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsChannelsSortActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<Integer, Unit> sortTypeSelectedListener = WidgetServerSettingsChannelsSortActions.this.getSortTypeSelectedListener();
            if (sortTypeSelectedListener != null) {
                sortTypeSelectedListener.invoke(4);
            }
            WidgetServerSettingsChannelsSortActions.this.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsChannelsSortActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<Integer, Unit> sortTypeSelectedListener = WidgetServerSettingsChannelsSortActions.this.getSortTypeSelectedListener();
            if (sortTypeSelectedListener != null) {
                sortTypeSelectedListener.invoke(2);
            }
            WidgetServerSettingsChannelsSortActions.this.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsChannelsSortActions.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<Integer, Unit> sortTypeSelectedListener = WidgetServerSettingsChannelsSortActions.this.getSortTypeSelectedListener();
            if (sortTypeSelectedListener != null) {
                sortTypeSelectedListener.invoke(0);
            }
            WidgetServerSettingsChannelsSortActions.this.dismiss();
        }
    }

    public WidgetServerSettingsChannelsSortActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannelsSortActions2.INSTANCE, null, 2, null);
    }

    private final void configureUI() {
        getBinding().f2551b.setOnClickListener(new AnonymousClass1());
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }

    private final WidgetServerSettingsChannelsSortActionsBinding getBinding() {
        return (WidgetServerSettingsChannelsSortActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_server_settings_channels_sort_actions;
    }

    public final Function1<Integer, Unit> getSortTypeSelectedListener() {
        return this.sortTypeSelectedListener;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }

    public final void setSortTypeSelectedListener(Function1<? super Integer, Unit> function1) {
        this.sortTypeSelectedListener = function1;
    }
}
