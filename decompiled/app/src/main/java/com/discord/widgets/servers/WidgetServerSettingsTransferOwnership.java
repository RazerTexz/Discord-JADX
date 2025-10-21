package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsTransferOwnership.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_USER_ID = "ARG_USER_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsTransferOwnership.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = WidgetServerSettingsTransferOwnership.class.getSimpleName();

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(long guildId, long userId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership = new WidgetServerSettingsTransferOwnership();
            Bundle bundleT = outline.T(WidgetServerSettingsTransferOwnership.ARG_GUILD_ID, guildId);
            bundleT.putLong(WidgetServerSettingsTransferOwnership.ARG_USER_ID, userId);
            widgetServerSettingsTransferOwnership.setArguments(bundleT);
            widgetServerSettingsTransferOwnership.show(fragmentManager, WidgetServerSettingsTransferOwnership.access$getTAG$cp());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final boolean isGuildOwner;
        private final boolean isMfaEnabled;
        private final User user;

        /* compiled from: WidgetServerSettingsTransferOwnership.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long userId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = Observable.i(companion.getGuilds().observeGuild(guildId), companion.getUsers().observeUser(userId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), WidgetServerSettingsTransferOwnership2.INSTANCE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(User user, Guild guild, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.user = user;
            this.guild = guild;
            this.isMfaEnabled = z2;
            this.isGuildOwner = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, User user, Guild guild, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                user = model.user;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                z2 = model.isMfaEnabled;
            }
            if ((i & 8) != 0) {
                z3 = model.isGuildOwner;
            }
            return model.copy(user, guild, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMfaEnabled() {
            return this.isMfaEnabled;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsGuildOwner() {
            return this.isGuildOwner;
        }

        public final Model copy(User user, Guild guild, boolean isMfaEnabled, boolean isGuildOwner) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(user, guild, isMfaEnabled, isGuildOwner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.guild, model.guild) && this.isMfaEnabled == model.isMfaEnabled && this.isGuildOwner == model.isGuildOwner;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isMfaEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isGuildOwner;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isGuildOwner() {
            return this.isGuildOwner;
        }

        public final boolean isMfaEnabled() {
            return this.isMfaEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", isMfaEnabled=");
            sbU.append(this.isMfaEnabled);
            sbU.append(", isGuildOwner=");
            return outline.O(sbU, this.isGuildOwner, ")");
        }
    }

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsTransferOwnership.this.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsTransferOwnership.access$getBinding$p(WidgetServerSettingsTransferOwnership.this).f2455b.toggle();
            MaterialButton materialButton = WidgetServerSettingsTransferOwnership.access$getBinding$p(WidgetServerSettingsTransferOwnership.this).d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildTransferOwnershipConfirm");
            CheckedSetting checkedSetting = WidgetServerSettingsTransferOwnership.access$getBinding$p(WidgetServerSettingsTransferOwnership.this).f2455b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildTransferOwnershipAcknowledgeCheck");
            materialButton.setEnabled(checkedSetting.isChecked());
        }
    }

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetServerSettingsTransferOwnership.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$configureUI$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetServerSettingsTransferOwnership.this.dismiss();
            }
        }

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().transferGuildOwnership(this.$model.getGuild().getId(), new RestAPIParams.TransferGuildOwnership(this.$model.getUser().getId(), WidgetServerSettingsTransferOwnership.access$getMfaCode$p(WidgetServerSettingsTransferOwnership.this))), false, 1, null), WidgetServerSettingsTransferOwnership.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsTransferOwnership.this.getClass();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    /* compiled from: WidgetServerSettingsTransferOwnership.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
            super(1, widgetServerSettingsTransferOwnership, WidgetServerSettingsTransferOwnership.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsTransferOwnership$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsTransferOwnership.access$configureUI((WidgetServerSettingsTransferOwnership) this.receiver, model);
        }
    }

    public WidgetServerSettingsTransferOwnership() {
        super(R.layout.widget_guild_transfer_ownership);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsTransferOwnership3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership, Model model) {
        widgetServerSettingsTransferOwnership.configureUI(model);
    }

    public static final /* synthetic */ WidgetGuildTransferOwnershipBinding access$getBinding$p(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        return widgetServerSettingsTransferOwnership.getBinding();
    }

    public static final /* synthetic */ String access$getMfaCode$p(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        return widgetServerSettingsTransferOwnership.getMfaCode();
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    private final void configureUI(Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildTransferOwnershipMfaWrap");
        linearLayout.setVisibility(model.isMfaEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildTransferOwnershipConfirm");
        CheckedSetting checkedSetting = getBinding().f2455b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildTransferOwnershipAcknowledgeCheck");
        materialButton.setEnabled(checkedSetting.isChecked());
        getBinding().f2455b.setText(FormatUtils.k(this, R.string.transfer_ownership_acknowledge, new Object[]{model.getUser().getUsername()}, null, 4));
        getBinding().f2455b.e(new AnonymousClass2());
        getBinding().d.setOnClickListener(new AnonymousClass3(model));
    }

    private final WidgetGuildTransferOwnershipBinding getBinding() {
        return (WidgetGuildTransferOwnershipBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getMfaCode() {
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildTransferOwnershipMfaCode");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildTransferOwnershipMfaCode");
            if (!(ViewExtensions.getTextOrEmpty(textInputLayout2).length() == 0)) {
                TextInputLayout textInputLayout3 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.guildTransferOwnershipMfaCode");
                return ViewExtensions.getTextOrEmpty(textInputLayout3);
            }
        }
        return null;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(ARG_GUILD_ID, -1L), getArgumentsOrDefault().getLong(ARG_USER_ID, -1L)), this, null, 2, null), WidgetServerSettingsTransferOwnership.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
