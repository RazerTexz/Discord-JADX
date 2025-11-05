package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditMemberBinding;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import com.discord.widgets.servers.WidgetServerSettingsTransferOwnership;
import com.discord.widgets.user.WidgetBanUser;
import com.discord.widgets.user.WidgetKickUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsEditMember.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEditMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditMemberBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_USER_ID = "INTENT_EXTRA_USER_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetServerSettingsEditMemberRolesAdapter rolesAdapter;
    private final StatefulViews state;

    /* compiled from: WidgetServerSettingsEditMember.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long userId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditMember.INTENT_EXTRA_USER_ID, userId);
            AppScreen2.d(context, WidgetServerSettingsEditMember.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canBan;
        private final boolean canChangeNickname;
        private final boolean canDisableCommunication;
        private final boolean canKick;
        private final boolean canManage;
        private final boolean canTransferOwnership;
        private final Guild guild;
        private final long myId;
        private final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> roleItems;
        private final User user;
        private final GuildMember userComputed;
        private final Set<Long> userRoles;

        /* compiled from: WidgetServerSettingsEditMember.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long userId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUsers().observeUser(userId), companion.getGuilds().observeComputed(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), new WidgetServerSettingsEditMember2(guildId, userId)).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, Guild guild, GuildMember guildMember, Set<Long> set, User user, List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildMember, "userComputed");
            Intrinsics3.checkNotNullParameter(set, "userRoles");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "roleItems");
            this.myId = j;
            this.guild = guild;
            this.userComputed = guildMember;
            this.userRoles = set;
            this.user = user;
            this.roleItems = list;
            this.canManage = z2;
            this.canKick = z3;
            this.canBan = z4;
            this.canChangeNickname = z5;
            this.canTransferOwnership = z6;
            this.canDisableCommunication = z7;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, Guild guild, GuildMember guildMember, Set set, User user, List list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.myId : j, (i & 2) != 0 ? model.guild : guild, (i & 4) != 0 ? model.userComputed : guildMember, (i & 8) != 0 ? model.userRoles : set, (i & 16) != 0 ? model.user : user, (i & 32) != 0 ? model.roleItems : list, (i & 64) != 0 ? model.canManage : z2, (i & 128) != 0 ? model.canKick : z3, (i & 256) != 0 ? model.canBan : z4, (i & 512) != 0 ? model.canChangeNickname : z5, (i & 1024) != 0 ? model.canTransferOwnership : z6, (i & 2048) != 0 ? model.canDisableCommunication : z7);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getCanTransferOwnership() {
            return this.canTransferOwnership;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildMember getUserComputed() {
            return this.userComputed;
        }

        public final Set<Long> component4() {
            return this.userRoles;
        }

        /* renamed from: component5, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> component6() {
            return this.roleItems;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getCanManage() {
            return this.canManage;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getCanKick() {
            return this.canKick;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanBan() {
            return this.canBan;
        }

        public final Model copy(long myId, Guild guild, GuildMember userComputed, Set<Long> userRoles, User user, List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> roleItems, boolean canManage, boolean canKick, boolean canBan, boolean canChangeNickname, boolean canTransferOwnership, boolean canDisableCommunication) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(userComputed, "userComputed");
            Intrinsics3.checkNotNullParameter(userRoles, "userRoles");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
            return new Model(myId, guild, userComputed, userRoles, user, roleItems, canManage, canKick, canBan, canChangeNickname, canTransferOwnership, canDisableCommunication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.myId == model.myId && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.userComputed, model.userComputed) && Intrinsics3.areEqual(this.userRoles, model.userRoles) && Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.roleItems, model.roleItems) && this.canManage == model.canManage && this.canKick == model.canKick && this.canBan == model.canBan && this.canChangeNickname == model.canChangeNickname && this.canTransferOwnership == model.canTransferOwnership && this.canDisableCommunication == model.canDisableCommunication;
        }

        public final boolean getCanBan() {
            return this.canBan;
        }

        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        public final boolean getCanKick() {
            return this.canKick;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final boolean getCanTransferOwnership() {
            return this.canTransferOwnership;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> getRoleItems() {
            return this.roleItems;
        }

        public final User getUser() {
            return this.user;
        }

        public final GuildMember getUserComputed() {
            return this.userComputed;
        }

        public final Set<Long> getUserRoles() {
            return this.userRoles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.myId) * 31;
            Guild guild = this.guild;
            int iHashCode = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
            GuildMember guildMember = this.userComputed;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            Set<Long> set = this.userRoles;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            User user = this.user;
            int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
            List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> list = this.roleItems;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.canManage;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            boolean z3 = this.canKick;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canBan;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.canChangeNickname;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.canTransferOwnership;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z7 = this.canDisableCommunication;
            return i10 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(myId=");
            sbU.append(this.myId);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", userComputed=");
            sbU.append(this.userComputed);
            sbU.append(", userRoles=");
            sbU.append(this.userRoles);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", roleItems=");
            sbU.append(this.roleItems);
            sbU.append(", canManage=");
            sbU.append(this.canManage);
            sbU.append(", canKick=");
            sbU.append(this.canKick);
            sbU.append(", canBan=");
            sbU.append(this.canBan);
            sbU.append(", canChangeNickname=");
            sbU.append(this.canChangeNickname);
            sbU.append(", canTransferOwnership=");
            sbU.append(this.canTransferOwnership);
            sbU.append(", canDisableCommunication=");
            return outline.O(sbU, this.canDisableCommunication, ")");
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$changeNickname$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $nickname;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$nickname = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetServerSettingsEditMember.access$onNicknameChangeSuccessful(WidgetServerSettingsEditMember.this, this.$nickname);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$changeNickname$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $nickname;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$nickname = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetServerSettingsEditMember.access$onNicknameChangeSuccessful(WidgetServerSettingsEditMember.this, this.$nickname);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass1(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetServerSettingsEditMember.access$getBinding$p(WidgetServerSettingsEditMember.this).e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
            TextInputLayout textInputLayout2 = WidgetServerSettingsEditMember.access$getBinding$p(WidgetServerSettingsEditMember.this).e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            int length = textOrEmpty.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics3.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            ViewExtensions.setText(textInputLayout, textOrEmpty.subSequence(i, length + 1).toString());
            WidgetServerSettingsEditMember widgetServerSettingsEditMember = WidgetServerSettingsEditMember.this;
            Model model = this.$data;
            TextInputLayout textInputLayout3 = WidgetServerSettingsEditMember.access$getBinding$p(widgetServerSettingsEditMember).e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
            WidgetServerSettingsEditMember.access$changeNickname(widgetServerSettingsEditMember, model, ViewExtensions.getTextOrEmpty(textInputLayout3));
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ boolean $isCommunicationDisabled;

        public AnonymousClass2(Model model, boolean z2) {
            this.$data = model;
            this.$isCommunicationDisabled = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long id2 = this.$data.getUser().getId();
            long id3 = this.$data.getGuild().getId();
            if (!this.$isCommunicationDisabled) {
                WidgetDisableGuildCommunication.INSTANCE.launch(id2, id3, WidgetServerSettingsEditMember.this.requireContext());
                return;
            }
            WidgetEnableGuildCommunication.Companion companion = WidgetEnableGuildCommunication.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.launch(id2, id3, parentFragmentManager);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ String $displayName;

        public AnonymousClass3(String str, Model model) {
            this.$displayName = str;
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetKickUser.Companion companion = WidgetKickUser.INSTANCE;
            String str = this.$displayName;
            long id2 = this.$data.getGuild().getId();
            long id3 = this.$data.getUser().getId();
            FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.launch(str, id2, id3, parentFragmentManager);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ String $displayName;

        public AnonymousClass4(String str, Model model) {
            this.$displayName = str;
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBanUser.INSTANCE.launch(this.$displayName, this.$data.getGuild().getId(), this.$data.getUser().getId(), WidgetServerSettingsEditMember.this.getParentFragmentManager());
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public AnonymousClass5(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$data.getGuild().getFeatures().contains(GuildFeature.VERIFIED) || this.$data.getGuild().getFeatures().contains(GuildFeature.PARTNERED)) {
                AppToast.i(WidgetServerSettingsEditMember.this, R.string.transfer_ownership_protected_guild, 0, 4);
                return;
            }
            WidgetServerSettingsTransferOwnership.Companion companion = WidgetServerSettingsTransferOwnership.INSTANCE;
            long id2 = this.$data.getGuild().getId();
            long id3 = this.$data.getUser().getId();
            FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.create(id2, id3, parentFragmentManager);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditMember widgetServerSettingsEditMember) {
            super(1, widgetServerSettingsEditMember, WidgetServerSettingsEditMember.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditMember$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditMember.access$configureUI((WidgetServerSettingsEditMember) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsEditMember.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$setupRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $data;

        /* compiled from: WidgetServerSettingsEditMember.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$setupRoles$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03081 extends Lambda implements Function1<Void, Unit> {
            public static final C03081 INSTANCE = new C03081();

            public C03081() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetServerSettingsEditMember.access$getBinding$p(WidgetServerSettingsEditMember.this).e.clearFocus();
            ArrayList arrayList = new ArrayList();
            if (this.$data.getUserRoles().contains(Long.valueOf(j))) {
                Iterator<Long> it = this.$data.getUserRoles().iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (jLongValue != j) {
                        arrayList.add(Long.valueOf(jLongValue));
                    }
                }
            } else {
                arrayList.addAll(this.$data.getUserRoles());
                arrayList.add(Long.valueOf(j));
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildMember(this.$data.getGuild().getId(), this.$data.getUser().getId(), RestAPIParams.GuildMember.INSTANCE.createWithRoles(arrayList)), false, 1, null), WidgetServerSettingsEditMember.this, null, 2, null), WidgetServerSettingsEditMember.this.getClass(), WidgetServerSettingsEditMember.this.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, C03081.INSTANCE, 60, (Object) null);
        }
    }

    public WidgetServerSettingsEditMember() {
        super(R.layout.widget_server_settings_edit_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditMember3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.edit_member_nickname);
    }

    public static final /* synthetic */ void access$changeNickname(WidgetServerSettingsEditMember widgetServerSettingsEditMember, Model model, String str) {
        widgetServerSettingsEditMember.changeNickname(model, str);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditMember widgetServerSettingsEditMember, Model model) {
        widgetServerSettingsEditMember.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsEditMemberBinding access$getBinding$p(WidgetServerSettingsEditMember widgetServerSettingsEditMember) {
        return widgetServerSettingsEditMember.getBinding();
    }

    public static final /* synthetic */ void access$onNicknameChangeSuccessful(WidgetServerSettingsEditMember widgetServerSettingsEditMember, String str) {
        widgetServerSettingsEditMember.onNicknameChangeSuccessful(str);
    }

    private final void changeNickname(Model data, String nickname) {
        if (data.getUser().getId() == data.getMyId()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildNickname(data.getGuild().getId(), new RestAPIParams.Nick(nickname)), false, 1, null), this, null, 2, null), WidgetServerSettingsEditMember.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(nickname), 60, (Object) null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildMember(data.getGuild().getId(), data.getUser().getId(), RestAPIParams.GuildMember.INSTANCE.createWithNick(nickname)), false, 1, null), this, null, 2, null), WidgetServerSettingsEditMember.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(nickname), 60, (Object) null);
        }
    }

    private final void configureUI(Model data) {
        if (data == null || !data.getCanManage()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        boolean z2 = true;
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Context context = getContext();
        setActionBarTitle(context != null ? FormatUtils.h(context, R.string.guild_members_header, new Object[]{data.getGuild().getName()}, null, 4) : null);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        setActionBarSubtitle(companion.getNickOrUsername(data.getUserComputed(), data.getUser()));
        setupNickname(data);
        setupRoles(data);
        this.state.configureSaveActionView(getBinding().h);
        getBinding().h.setOnClickListener(new AnonymousClass1(data));
        String nickOrUsername = companion.getNickOrUsername(data.getUserComputed(), data.getUser());
        if (data.getCanDisableCommunication()) {
            boolean zIsCommunicationDisabled = data.getUserComputed().isCommunicationDisabled();
            TextView textView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.editMemberTimeoutButton");
            FormatUtils.n(textView, zIsCommunicationDisabled ? R.string.enable_guild_communication_for_user : R.string.disable_guild_communication_for_user, new Object[]{nickOrUsername}, null, 4);
            TextView textView2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.editMemberTimeoutButton");
            textView2.setVisibility(0);
            getBinding().i.setOnClickListener(new AnonymousClass2(data, zIsCommunicationDisabled));
        } else {
            TextView textView3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.editMemberTimeoutButton");
            textView3.setVisibility(8);
            getBinding().i.setOnClickListener(null);
        }
        if (data.getCanKick()) {
            TextView textView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.editMemberKickButton");
            FormatUtils.n(textView4, R.string.kick_user, new Object[]{nickOrUsername}, null, 4);
            TextView textView5 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.editMemberKickButton");
            textView5.setVisibility(0);
            getBinding().d.setOnClickListener(new AnonymousClass3(nickOrUsername, data));
        } else {
            TextView textView6 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.editMemberKickButton");
            textView6.setVisibility(8);
            getBinding().d.setOnClickListener(null);
        }
        if (data.getCanBan()) {
            TextView textView7 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.editMemberBanButton");
            FormatUtils.n(textView7, R.string.ban_user, new Object[]{nickOrUsername}, null, 4);
            TextView textView8 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.editMemberBanButton");
            textView8.setVisibility(0);
            getBinding().c.setOnClickListener(new AnonymousClass4(nickOrUsername, data));
        } else {
            TextView textView9 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.editMemberBanButton");
            textView9.setVisibility(8);
            getBinding().c.setOnClickListener(null);
        }
        if (data.getCanTransferOwnership()) {
            TextView textView10 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.editMemberTransferOwnershipButton");
            textView10.setVisibility(0);
            getBinding().j.setOnClickListener(new AnonymousClass5(data));
        } else {
            TextView textView11 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView11, "binding.editMemberTransferOwnershipButton");
            textView11.setVisibility(8);
            getBinding().j.setOnClickListener(null);
        }
        LinearLayout linearLayout = getBinding().f2561b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editMemberAdministrativeContainer");
        if (!data.getCanKick() && !data.getCanBan() && !data.getCanTransferOwnership()) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    private final WidgetServerSettingsEditMemberBinding getBinding() {
        return (WidgetServerSettingsEditMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onNicknameChangeSuccessful(String nickname) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        AppToast.j(this, nickname.length() > 0 ? FormatUtils.k(this, R.string.nickname_changed, new Object[]{nickname}, null, 4) : FormatUtils.k(this, R.string.nickname_cleared, new Object[0], null, 4), 0, 4);
    }

    private final void setupNickname(Model data) {
        String nick = data.getUserComputed().getNick();
        if (nick == null) {
            nick = "";
        }
        if (data.getCanChangeNickname()) {
            TextInputLayout textInputLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
            textInputLayout.setEndIconVisible(false);
            TextInputLayout textInputLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
            textInputLayout2.setEnabled(true);
        } else {
            TextInputLayout textInputLayout3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
            textInputLayout3.setEndIconVisible(true);
            TextInputLayout textInputLayout4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editMemberNickname");
            textInputLayout4.setEnabled(false);
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout5 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editMemberNickname");
            statefulViews.put(textInputLayout5.getId(), nick);
        }
        TextInputLayout textInputLayout6 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.editMemberNickname");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout7 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.editMemberNickname");
        ViewExtensions.setText(textInputLayout6, (CharSequence) statefulViews2.get(textInputLayout7.getId(), nick));
    }

    private final void setupRoles(Model data) {
        WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter;
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editMemberRolesContainer");
        linearLayout.setVisibility(data.getRoleItems().isEmpty() ^ true ? 0 : 8);
        if (!(!data.getRoleItems().isEmpty()) || (widgetServerSettingsEditMemberRolesAdapter = this.rolesAdapter) == null) {
            return;
        }
        widgetServerSettingsEditMemberRolesAdapter.configure(data.getRoleItems(), new AnonymousClass1(data));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.editMemberRolesRecycler");
        this.rolesAdapter = (WidgetServerSettingsEditMemberRolesAdapter) companion.configure(new WidgetServerSettingsEditMemberRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.editMemberRolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getBinding().g.setHasFixedSize(false);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().h;
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_USER_ID, -1L);
        StoreStream.INSTANCE.getGuildSubscriptions().subscribeUser(longExtra, longExtra2);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
