package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetBanUser.kt */
/* loaded from: classes.dex */
public final class WidgetBanUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetBanUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBanUserBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager deleteHistoryRadioManager;

    /* compiled from: WidgetBanUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
            m.checkNotNullParameter(userName, "userName");
            if (fragmentManager == null) {
                return;
            }
            WidgetBanUser widgetBanUser = new WidgetBanUser();
            Bundle bundle = new Bundle();
            bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            widgetBanUser.setArguments(bundle);
            widgetBanUser.show(fragmentManager, WidgetBanUser.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetBanUser.kt */
    /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBanUser.this.dismiss();
        }
    }

    /* compiled from: WidgetBanUser.kt */
    /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ String $userName;

        /* compiled from: WidgetBanUser.kt */
        /* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r7) {
                Context context = WidgetBanUser.this.getContext();
                Context context2 = WidgetBanUser.this.getContext();
                b.a.d.m.h(context, context2 != null ? b.h(context2, R.string.ban_user_confirmed, new Object[]{AnonymousClass3.this.$userName}, null, 4) : null, 0, null, 12);
                WidgetBanUser.this.dismiss();
            }
        }

        public AnonymousClass3(long j, long j2, String str) {
            this.$guildId = j;
            this.$userId = j2;
            this.$userName = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            List listAccess$getHistoryRadios$p = WidgetBanUser.access$getHistoryRadios$p(WidgetBanUser.this);
            RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(WidgetBanUser.this);
            switch (((CheckedSetting) listAccess$getHistoryRadios$p.get(radioManagerAccess$getDeleteHistoryRadioManager$p != null ? radioManagerAccess$getDeleteHistoryRadioManager$p.b() : 0)).getId()) {
                case R.id.ban_user_delete_messages_1_day /* 2131362131 */:
                    i = 1;
                    break;
                case R.id.ban_user_delete_messages_7_days /* 2131362132 */:
                    i = 7;
                    break;
                case R.id.ban_user_delete_messages_none /* 2131362133 */:
                default:
                    i = 0;
                    break;
            }
            TextInputLayout textInputLayout = WidgetBanUser.access$getBinding$p(WidgetBanUser.this).h;
            m.checkNotNullExpressionValue(textInputLayout, "binding.banUserReason");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().banGuildMember(this.$guildId, this.$userId, new RestAPIParams.BanGuildMember(Integer.valueOf(i)), t.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), WidgetBanUser.this, null, 2, null), WidgetBanUser.this.getClass(), WidgetBanUser.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    public WidgetBanUser() {
        super(R.layout.widget_ban_user);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetBanUser$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetBanUserBinding access$getBinding$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.deleteHistoryRadioManager;
    }

    public static final /* synthetic */ List access$getHistoryRadios$p(WidgetBanUser widgetBanUser) {
        return widgetBanUser.getHistoryRadios();
    }

    public static final /* synthetic */ void access$setDeleteHistoryRadioManager$p(WidgetBanUser widgetBanUser, RadioManager radioManager) {
        widgetBanUser.deleteHistoryRadioManager = radioManager;
    }

    private final WidgetBanUserBinding getBinding() {
        return (WidgetBanUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getHistoryRadios() {
        CheckedSetting checkedSetting = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting, "binding.banUserDeleteMessagesNone");
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.banUserDeleteMessages1Day");
        CheckedSetting checkedSetting3 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.banUserDeleteMessages7Days");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.deleteHistoryRadioManager = new RadioManager(getHistoryRadios());
        for (CheckedSetting checkedSetting : getHistoryRadios()) {
            checkedSetting.e(new WidgetBanUser$onViewBound$$inlined$forEach$lambda$1(checkedSetting, this));
        }
        String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.banUserTitle");
        b.n(textView, R.string.ban_user_title, new Object[]{string}, null, 4);
        TextView textView2 = getBinding().f2240b;
        m.checkNotNullExpressionValue(textView2, "binding.banUserBody");
        b.n(textView2, R.string.ban_user_body, new Object[]{string}, null, 4);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().d.setOnClickListener(new AnonymousClass3(j, j2, string));
    }
}
