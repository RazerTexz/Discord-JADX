package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEditRoleBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p440k.p441a.p442a.ColorPickerDialogListener;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsEditRole.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditRoleBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_ROLE_ID = "INTENT_EXTRA_ROLE_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long roleId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditRole.INTENT_EXTRA_ROLE_ID, roleId);
            AppScreen2.m156d(context, WidgetServerSettingsEditRole.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final boolean hasGuildCommunicationDisabledFeature;
        private final boolean isCommunityServer;
        private final ManageStatus manageStatus;
        private final Long myPermissions;
        private final long myPermissionsFromOtherRoles;
        private final boolean owner;
        private final GuildRole role;
        private final boolean useNewThreadPermissions;

        /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ ManageStatus access$computeManageStatus(Companion companion, boolean z2, boolean z3, Long l, GuildRole guildRole, GuildRole guildRole2) {
                return companion.computeManageStatus(z2, z3, l, guildRole, guildRole2);
            }

            public static final /* synthetic */ long access$computeMyOtherPermissions(Companion companion, Collection collection, Map map, long j, long j2) {
                return companion.computeMyOtherPermissions(collection, map, j, j2);
            }

            private final ManageStatus computeManageStatus(boolean isOwner, boolean isElevated, Long myPermissions, GuildRole myHighestRole, GuildRole role) {
                return (isOwner || (PermissionUtils.can(8L, myPermissions) && RoleUtils.rankIsHigher(myHighestRole, role) && isElevated)) ? ManageStatus.CAN_MANAGE_ADMIN : RoleUtils.rankIsHigher(role, myHighestRole) ? ManageStatus.LOCKED_HIGHER : RoleUtils.rankEquals(myHighestRole, role) ? ManageStatus.LOCKED_HIGHEST : (PermissionUtils.can(Permission.MANAGE_ROLES, myPermissions) && isElevated) ? ManageStatus.CAN_MANAGE_CONDITIONAL : !isElevated ? ManageStatus.USER_NOT_ELEVATED : ManageStatus.NO_MANAGE_ROLES_PERMISSION;
            }

            private final long computeMyOtherPermissions(Collection<Long> myRoleIds, Map<Long, GuildRole> guildRoles, long ignoreRoleId, long guildId) {
                GuildRole guildRole = guildRoles.get(Long.valueOf(guildId));
                long permissions = 0;
                if (guildRole != null && ignoreRoleId != guildId) {
                    permissions = guildRole.getPermissions() | 0 | guildRole.getPermissions();
                }
                Iterator<T> it = myRoleIds.iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    GuildRole guildRole2 = guildRoles.get(Long.valueOf(jLongValue));
                    if (guildRole2 != null && jLongValue != ignoreRoleId) {
                        permissions = guildRole2.getPermissions() | permissions;
                    }
                }
                return permissions;
            }

            public final Observable<Model> get(long guildId, long roleId) {
                Observable<Model> observableM11112r = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).m11099Y(new WidgetServerSettingsEditRole2(guildId, roleId)).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
        public enum ManageStatus {
            NO_MANAGE_ROLES_PERMISSION,
            LOCKED_HIGHER,
            LOCKED_HIGHEST,
            USER_NOT_ELEVATED,
            CAN_MANAGE_CONDITIONAL,
            CAN_MANAGE_ADMIN
        }

        public Model(boolean z2, long j, GuildRole guildRole, ManageStatus manageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.owner = z2;
            this.guildId = j;
            this.role = guildRole;
            this.manageStatus = manageStatus;
            this.myPermissions = l;
            this.myPermissionsFromOtherRoles = j2;
            this.isCommunityServer = z3;
            this.useNewThreadPermissions = z4;
            this.hasGuildCommunicationDisabledFeature = z5;
        }

        public static /* synthetic */ Model copy$default(Model model, boolean z2, long j, GuildRole guildRole, ManageStatus manageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.owner : z2, (i & 2) != 0 ? model.guildId : j, (i & 4) != 0 ? model.role : guildRole, (i & 8) != 0 ? model.manageStatus : manageStatus, (i & 16) != 0 ? model.myPermissions : l, (i & 32) != 0 ? model.myPermissionsFromOtherRoles : j2, (i & 64) != 0 ? model.isCommunityServer : z3, (i & 128) != 0 ? model.useNewThreadPermissions : z4, (i & 256) != 0 ? model.hasGuildCommunicationDisabledFeature : z5);
        }

        public final boolean canManage() {
            ManageStatus manageStatus = this.manageStatus;
            return manageStatus == ManageStatus.CAN_MANAGE_CONDITIONAL || manageStatus == ManageStatus.CAN_MANAGE_ADMIN;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getOwner() {
            return this.owner;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ManageStatus getManageStatus() {
            return this.manageStatus;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getMyPermissions() {
            return this.myPermissions;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getMyPermissionsFromOtherRoles() {
            return this.myPermissionsFromOtherRoles;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsCommunityServer() {
            return this.isCommunityServer;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getUseNewThreadPermissions() {
            return this.useNewThreadPermissions;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getHasGuildCommunicationDisabledFeature() {
            return this.hasGuildCommunicationDisabledFeature;
        }

        public final Model copy(boolean owner, long guildId, GuildRole role, ManageStatus manageStatus, Long myPermissions, long myPermissionsFromOtherRoles, boolean isCommunityServer, boolean useNewThreadPermissions, boolean hasGuildCommunicationDisabledFeature) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new Model(owner, guildId, role, manageStatus, myPermissions, myPermissionsFromOtherRoles, isCommunityServer, useNewThreadPermissions, hasGuildCommunicationDisabledFeature);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.owner == model.owner && this.guildId == model.guildId && Intrinsics3.areEqual(this.role, model.role) && Intrinsics3.areEqual(this.manageStatus, model.manageStatus) && Intrinsics3.areEqual(this.myPermissions, model.myPermissions) && this.myPermissionsFromOtherRoles == model.myPermissionsFromOtherRoles && this.isCommunityServer == model.isCommunityServer && this.useNewThreadPermissions == model.useNewThreadPermissions && this.hasGuildCommunicationDisabledFeature == model.hasGuildCommunicationDisabledFeature;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getHasGuildCommunicationDisabledFeature() {
            return this.hasGuildCommunicationDisabledFeature;
        }

        public final ManageStatus getManageStatus() {
            return this.manageStatus;
        }

        public final Long getMyPermissions() {
            return this.myPermissions;
        }

        public final long getMyPermissionsFromOtherRoles() {
            return this.myPermissionsFromOtherRoles;
        }

        public final boolean getOwner() {
            return this.owner;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public final boolean getUseNewThreadPermissions() {
            return this.useNewThreadPermissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        public int hashCode() {
            boolean z2 = this.owner;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int iM3a = (C0002b.m3a(this.guildId) + (r0 * 31)) * 31;
            GuildRole guildRole = this.role;
            int iHashCode = (iM3a + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
            ManageStatus manageStatus = this.manageStatus;
            int iHashCode2 = (iHashCode + (manageStatus != null ? manageStatus.hashCode() : 0)) * 31;
            Long l = this.myPermissions;
            int iM3a2 = (C0002b.m3a(this.myPermissionsFromOtherRoles) + ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
            boolean z3 = this.isCommunityServer;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i = (iM3a2 + r2) * 31;
            boolean z4 = this.useNewThreadPermissions;
            ?? r22 = z4;
            if (z4) {
                r22 = 1;
            }
            int i2 = (i + r22) * 31;
            boolean z5 = this.hasGuildCommunicationDisabledFeature;
            return i2 + (z5 ? 1 : z5);
        }

        public final boolean isCommunityServer() {
            return this.isCommunityServer;
        }

        public final boolean isEveryoneRole() {
            return this.role.getId() == this.guildId;
        }

        public final boolean isSingular(long permission) {
            return (this.owner || (this.myPermissionsFromOtherRoles & permission) == permission) ? false : true;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(owner=");
            sbM833U.append(this.owner);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", role=");
            sbM833U.append(this.role);
            sbM833U.append(", manageStatus=");
            sbM833U.append(this.manageStatus);
            sbM833U.append(", myPermissions=");
            sbM833U.append(this.myPermissions);
            sbM833U.append(", myPermissionsFromOtherRoles=");
            sbM833U.append(this.myPermissionsFromOtherRoles);
            sbM833U.append(", isCommunityServer=");
            sbM833U.append(this.isCommunityServer);
            sbM833U.append(", useNewThreadPermissions=");
            sbM833U.append(this.useNewThreadPermissions);
            sbM833U.append(", hasGuildCommunicationDisabledFeature=");
            return outline.m827O(sbM833U, this.hasGuildCommunicationDisabledFeature, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Model.ManageStatus.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[Model.ManageStatus.CAN_MANAGE_CONDITIONAL.ordinal()] = 1;
            iArr[Model.ManageStatus.CAN_MANAGE_ADMIN.ordinal()] = 2;
            Model.ManageStatus.values();
            int[] iArr2 = new int[6];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Model.ManageStatus.NO_MANAGE_ROLES_PERMISSION.ordinal()] = 1;
            iArr2[Model.ManageStatus.LOCKED_HIGHER.ordinal()] = 2;
            iArr2[Model.ManageStatus.LOCKED_HIGHEST.ordinal()] = 3;
            iArr2[Model.ManageStatus.USER_NOT_ELEVATED.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$configureUI$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92351 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92351(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16526b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
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
            String string = textOrEmpty.subSequence(i, length + 1).toString();
            if (!(string.length() > 0)) {
                AppToast.m171i(WidgetServerSettingsEditRole.this, C5419R.string.form_label_role_enter_name, 0, 4);
                return;
            }
            TextInputLayout textInputLayout2 = WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16526b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
            textInputLayout2.setSelected(false);
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setName(string);
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
            AppFragment.hideKeyboard$default(WidgetServerSettingsEditRole.this, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$enableSetting$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92361 implements View.OnClickListener {
        public final /* synthetic */ Model $data;
        public final /* synthetic */ long $permission;

        public ViewOnClickListenerC92361(Model model, long j) {
            this.$data = model;
            this.$permission = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16526b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setPermissions(Long.valueOf(this.$data.getRole().getPermissions() ^ this.$permission));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$launchColorPicker$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class C92371 implements ColorPickerDialogListener {
        public final /* synthetic */ Model $data;

        public C92371(Model model) {
            this.$data = model;
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setColor(0);
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            roleCreateWithRole.setColor(Integer.valueOf(ColorCompat.INSTANCE.removeAlphaComponent(selectedColor)));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final /* synthetic */ class C92381 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C92381(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
            super(1, widgetServerSettingsEditRole, WidgetServerSettingsEditRole.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditRole.access$configureUI((WidgetServerSettingsEditRole) this.receiver, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$patchRole$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class C92391<T> implements Action1<Void> {
        public static final C92391 INSTANCE = new C92391();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Void r1) {
            call2(r1);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupActionBar$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class C92401 extends Lambda implements Function2<String, Integer, SpannableStringBuilder> {
        public static final C92401 INSTANCE = new C92401();

        public C92401() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ SpannableStringBuilder invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }

        public final SpannableStringBuilder invoke(String str, @ColorInt int i) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder.length(), 0);
            return spannableStringBuilder;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupColorSetting$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92411 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92411(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$launchColorPicker(WidgetServerSettingsEditRole.this, this.$data);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupColorSetting$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92422 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92422(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole widgetServerSettingsEditRole = WidgetServerSettingsEditRole.this;
            AppToast.m172j(widgetServerSettingsEditRole, WidgetServerSettingsEditRole.access$getLockMessage(widgetServerSettingsEditRole, this.$data, true), 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupHoistAndMentionSettings$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92431 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92431(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16526b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16541q, "binding.roleSettingsHoistCheckedsetting");
            roleCreateWithRole.setHoist(Boolean.valueOf(!r0.isChecked()));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupHoistAndMentionSettings$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92442 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92442(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16526b.clearFocus();
            RestAPIParams.Role roleCreateWithRole = RestAPIParams.Role.INSTANCE.createWithRole(this.$data.getRole());
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsEditRole.access$getBinding$p(WidgetServerSettingsEditRole.this).f16501D, "binding.roleSettingsMentionableCheckedsetting");
            roleCreateWithRole.setMentionable(Boolean.valueOf(!r0.isChecked()));
            WidgetServerSettingsEditRole.access$patchRole(WidgetServerSettingsEditRole.this, this.$data.getGuildId(), roleCreateWithRole);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupMenu$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class C92451<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $data;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupMenu$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) throws Exception {
                call2(r1);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r1) throws Exception {
                AppActivity appActivity = WidgetServerSettingsEditRole.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        }

        public C92451(Model model) {
            this.$data = model;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            if (menuItem.getItemId() == C5419R.id.menu_edit_role_delete) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteRole(this.$data.getGuildId(), this.$data.getRole().getId()), false, 1, null), WidgetServerSettingsEditRole.this, null, 2, null).m11108k(C0879o.m183j(new AnonymousClass1(), WidgetServerSettingsEditRole.this.getContext(), null, 4));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$setupRoleName$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
    public static final class ViewOnClickListenerC92461 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC92461(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole widgetServerSettingsEditRole = WidgetServerSettingsEditRole.this;
            AppToast.m172j(widgetServerSettingsEditRole, WidgetServerSettingsEditRole.access$getLockMessage(widgetServerSettingsEditRole, this.$data, true), 0, 4);
        }
    }

    public WidgetServerSettingsEditRole() {
        super(C5419R.layout.widget_edit_role);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditRole3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.edit_role_name);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model) {
        widgetServerSettingsEditRole.configureUI(model);
    }

    public static final /* synthetic */ WidgetEditRoleBinding access$getBinding$p(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
        return widgetServerSettingsEditRole.getBinding();
    }

    public static final /* synthetic */ String access$getLockMessage(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model, boolean z2) {
        return widgetServerSettingsEditRole.getLockMessage(model, z2);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetServerSettingsEditRole widgetServerSettingsEditRole, Model model) {
        widgetServerSettingsEditRole.launchColorPicker(model);
    }

    public static final /* synthetic */ void access$patchRole(WidgetServerSettingsEditRole widgetServerSettingsEditRole, long j, RestAPIParams.Role role) {
        widgetServerSettingsEditRole.patchRole(j, role);
    }

    private final void configureUI(Model data) {
        if ((data != null ? data.getRole() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setupMenu(data);
        setupActionBar(data);
        setupRoleName(data);
        setupHoistAndMentionSettings(data);
        setupPermissionsSettings(data);
        setupColorSetting(data);
        setRoleIcon(data);
        this.state.configureSaveActionView(getBinding().f16527c);
        getBinding().f16527c.setOnClickListener(new ViewOnClickListenerC92351(data));
        if (data.getUseNewThreadPermissions()) {
            return;
        }
        CheckedSetting.m8524i(getBinding().f16510M, getString(C5419R.string.role_permissions_send_messages_description), false, 2);
        getBinding().f16511N.setText(getString(C5419R.string.interim_send_messages_in_threads));
        getBinding().f16511N.m8530h(FormatUtils.m219k(this, C5419R.string.interim_role_permissions_send_messages_in_threads_description, new Object[0], null, 4), true);
        getBinding().f16537m.setText(getString(C5419R.string.interim_create_public_threads));
        getBinding().f16537m.m8530h(FormatUtils.m219k(this, C5419R.string.interim_role_permissions_create_public_threads_description, new Object[0], null, 4), true);
        getBinding().f16536l.setText(getString(C5419R.string.interim_create_private_threads));
        getBinding().f16536l.m8530h(FormatUtils.m219k(this, C5419R.string.interim_role_permissions_create_private_threads_description, new Object[0], null, 4), true);
    }

    private final void enableSetting(CheckedSetting setting, Model data, long permission) {
        setting.m8527e(new ViewOnClickListenerC92361(data, permission));
    }

    private final WidgetEditRoleBinding getBinding() {
        return (WidgetEditRoleBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getLockMessage(Model data, boolean everyoneLocked) {
        String string;
        if (everyoneLocked && data.isEveryoneRole()) {
            String string2 = getString(C5419R.string.form_label_disabled_for_everyone);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.form_…el_disabled_for_everyone)");
            return string2;
        }
        Model.ManageStatus manageStatus = data.getManageStatus();
        if (manageStatus != null) {
            int iOrdinal = manageStatus.ordinal();
            string = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : getString(C5419R.string.two_fa_guild_mfa_warning_ios) : getString(C5419R.string.help_role_locked_mine) : getString(C5419R.string.help_role_locked) : getString(C5419R.string.help_missing_manage_roles_permission);
        }
        Intrinsics3.checkNotNullExpressionValue(string, "when (data.manageStatus)…s)\n      else -> \"\"\n    }");
        return string;
    }

    public static final void launch(long j, long j2, Context context) {
        INSTANCE.launch(j, j2, context);
    }

    private final void launchColorPicker(Model data) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), C5419R.string.role_color, RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null));
        colorPickerDialogBuildColorPickerDialog.f21719k = new C92371(data);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void patchRole(long guildId, RestAPIParams.Role roleParams) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateRole(guildId, roleParams.getId(), roleParams), false, 1, null), this, null, 2, null).m11108k(C0879o.m183j(C92391.INSTANCE, getContext(), null, 4));
    }

    private final void setRoleIcon(Model data) {
        if (data.getRole().getIcon() != null) {
            String icon = data.getRole().getIcon();
            Intrinsics3.checkNotNull(icon);
            if (icon.length() > 0) {
                getBinding().f16507J.setRole(data.getRole(), Long.valueOf(data.getGuildId()));
                TextView textView = getBinding().f16509L;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.roleSettingsRoleIconHeader");
                textView.setVisibility(0);
                View view = getBinding().f16508K;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsRoleIconDivider");
                view.setVisibility(0);
                RelativeLayout relativeLayout = getBinding().f16542r;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.roleSettingsIconContainer");
                relativeLayout.setVisibility(0);
                return;
            }
        }
        TextView textView2 = getBinding().f16509L;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.roleSettingsRoleIconHeader");
        textView2.setVisibility(8);
        View view2 = getBinding().f16508K;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsRoleIconDivider");
        view2.setVisibility(8);
        RelativeLayout relativeLayout2 = getBinding().f16542r;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.roleSettingsIconContainer");
        relativeLayout2.setVisibility(8);
    }

    private final void setupActionBar(Model data) {
        int iHSVToColor;
        AppActivity appActivity = getAppActivity();
        Toolbar toolbar = appActivity != null ? appActivity.toolbar : null;
        if (toolbar != null) {
            int roleColor = RoleUtils.getRoleColor(data.getRole(), requireContext(), Integer.valueOf(ColorCompat.getThemedColor(requireContext(), C5419R.attr.color_brand)));
            if (RoleUtils.isDefaultColor(data.getRole())) {
                iHSVToColor = ColorCompat.getThemedColor(this, C5419R.attr.color_brand_460);
            } else {
                float[] fArr = new float[3];
                Color.colorToHSV(roleColor, fArr);
                fArr[2] = fArr[2] * 0.5f;
                iHSVToColor = Color.HSVToColor(fArr);
            }
            boolean zIsColorDark$default = ColorCompat.isColorDark$default(roleColor, 0.0f, 2, null);
            int color = ColorCompat.getColor(requireContext(), zIsColorDark$default ? C5419R.color.primary_100 : C5419R.color.primary_500);
            ColorCompat.setStatusBarColor(this, iHSVToColor, zIsColorDark$default);
            C92401 c92401 = C92401.INSTANCE;
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            String string = getString(C5419R.string.form_label_role_settings);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.form_label_role_settings)");
            setActionBarTitle(c92401.invoke(string, color));
            setActionBarSubtitle(c92401.invoke(data.getRole().getName(), color));
            toolbar.setBackgroundColor(roleColor);
            Drawable navigationIcon = toolbar.getNavigationIcon();
            if (navigationIcon != null) {
                navigationIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
            }
            Drawable overflowIcon = toolbar.getOverflowIcon();
            if (overflowIcon != null) {
                overflowIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
            }
        }
    }

    private final void setupColorSetting(Model data) {
        View view = getBinding().f16538n;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsCurrentColorDisplay");
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), C5419R.drawable.drawable_circle_white_1);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null), PorterDuff.Mode.SRC_ATOP));
            View view2 = getBinding().f16538n;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsCurrentColorDisplay");
            view2.setBackground(drawable);
        }
        if (!data.canManage() || data.isEveryoneRole()) {
            View view3 = getBinding().f16533i;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.roleSettingsColorDisabledOverlay");
            view3.setVisibility(0);
            getBinding().f16533i.setOnClickListener(new ViewOnClickListenerC92422(data));
            return;
        }
        getBinding().f16534j.setOnClickListener(new ViewOnClickListenerC92411(data));
        View view4 = getBinding().f16533i;
        Intrinsics3.checkNotNullExpressionValue(view4, "binding.roleSettingsColorDisabledOverlay");
        view4.setVisibility(8);
        getBinding().f16533i.setOnClickListener(null);
    }

    private final void setupHoistAndMentionSettings(Model data) {
        CheckedSetting checkedSetting = getBinding().f16541q;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.roleSettingsHoistCheckedsetting");
        checkedSetting.setChecked(data.getRole().getHoist());
        CheckedSetting checkedSetting2 = getBinding().f16501D;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsMentionableCheckedsetting");
        checkedSetting2.setChecked(data.getRole().getMentionable());
        if (data.canManage() && !data.isEveryoneRole()) {
            getBinding().f16541q.m8527e(new ViewOnClickListenerC92431(data));
            getBinding().f16501D.m8527e(new ViewOnClickListenerC92442(data));
        } else {
            String lockMessage = getLockMessage(data, true);
            getBinding().f16541q.m8526c(lockMessage);
            getBinding().f16501D.m8526c(lockMessage);
        }
    }

    private final void setupMenu(Model data) {
        if (!data.canManage() || data.isEveryoneRole() || data.getRole().getManaged()) {
            AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_empty, null, null, 4, null);
        } else {
            AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_edit_role, new C92451(data), null, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupPermissionsSettings(Model data) {
        long j;
        for (CheckedSetting checkedSetting : Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().f16529e, getBinding().f16530f, getBinding().f16531g, getBinding().f16532h, getBinding().f16535k, getBinding().f16540p, getBinding().f16543s, getBinding().f16544t, getBinding().f16547w, getBinding().f16498A, getBinding().f16548x, getBinding().f16545u, getBinding().f16549y, getBinding().f16550z, getBinding().f16502E, getBinding().f16499B, getBinding().f16500C, getBinding().f16504G, getBinding().f16505H, getBinding().f16510M, getBinding().f16511N, getBinding().f16537m, getBinding().f16536l, getBinding().f16512O, getBinding().f16513P, getBinding().f16514Q, getBinding().f16515R, getBinding().f16528d, getBinding().f16516S, getBinding().f16518U, getBinding().f16522Y, getBinding().f16525a0, getBinding().f16521X, getBinding().f16519V, getBinding().f16520W, getBinding().f16523Z, getBinding().f16503F, getBinding().f16517T, getBinding().f16506I, getBinding().f16546v})) {
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "setting");
            switch (checkedSetting.getId()) {
                case C5419R.id.role_settings_add_reactions /* 2131364965 */:
                    j = 64;
                    break;
                case C5419R.id.role_settings_administrator /* 2131364966 */:
                    j = 8;
                    break;
                case C5419R.id.role_settings_attach_files /* 2131364967 */:
                    j = Permission.ATTACH_FILES;
                    break;
                case C5419R.id.role_settings_ban_members /* 2131364968 */:
                    j = 4;
                    break;
                case C5419R.id.role_settings_change_nickname /* 2131364969 */:
                    j = Permission.CHANGE_NICKNAME;
                    break;
                case C5419R.id.role_settings_color_disabled_overlay /* 2131364970 */:
                case C5419R.id.role_settings_color_selector_container /* 2131364971 */:
                case C5419R.id.role_settings_current_color_display /* 2131364975 */:
                case C5419R.id.role_settings_edit_name_disabled_overlay /* 2131364976 */:
                case C5419R.id.role_settings_hoist_checkedsetting /* 2131364978 */:
                case C5419R.id.role_settings_icon_container /* 2131364979 */:
                case C5419R.id.role_settings_mentionable_checkedsetting /* 2131364991 */:
                case C5419R.id.role_settings_overview_scroll /* 2131364993 */:
                case C5419R.id.role_settings_role_icon /* 2131364998 */:
                case C5419R.id.role_settings_role_icon_divider /* 2131364999 */:
                case C5419R.id.role_settings_role_icon_header /* 2131365000 */:
                default:
                    j = 0;
                    break;
                case C5419R.id.role_settings_create_instant_invite /* 2131364972 */:
                    j = 1;
                    break;
                case C5419R.id.role_settings_create_private_threads /* 2131364973 */:
                    j = Permission.CREATE_PRIVATE_THREADS;
                    break;
                case C5419R.id.role_settings_create_public_threads /* 2131364974 */:
                    j = Permission.CREATE_PUBLIC_THREADS;
                    break;
                case C5419R.id.role_settings_embed_links /* 2131364977 */:
                    j = Permission.EMBED_LINKS;
                    break;
                case C5419R.id.role_settings_kick_members /* 2131364980 */:
                    j = 2;
                    break;
                case C5419R.id.role_settings_manage_channels /* 2131364981 */:
                    j = 16;
                    break;
                case C5419R.id.role_settings_manage_emojis_and_stickers /* 2131364982 */:
                    j = Permission.MANAGE_EMOJIS_AND_STICKERS;
                    break;
                case C5419R.id.role_settings_manage_events /* 2131364983 */:
                    j = Permission.MANAGE_EVENTS;
                    break;
                case C5419R.id.role_settings_manage_messages /* 2131364984 */:
                    j = Permission.MANAGE_MESSAGES;
                    break;
                case C5419R.id.role_settings_manage_nicknames /* 2131364985 */:
                    j = Permission.MANAGE_NICKNAMES;
                    break;
                case C5419R.id.role_settings_manage_roles /* 2131364986 */:
                    j = Permission.MANAGE_ROLES;
                    break;
                case C5419R.id.role_settings_manage_server /* 2131364987 */:
                    j = 32;
                    break;
                case C5419R.id.role_settings_manage_threads /* 2131364988 */:
                    j = Permission.MANAGE_THREADS;
                    break;
                case C5419R.id.role_settings_manage_webhooks /* 2131364989 */:
                    j = Permission.MANAGE_WEBHOOKS;
                    break;
                case C5419R.id.role_settings_mention_everyone /* 2131364990 */:
                    j = Permission.MENTION_EVERYONE;
                    break;
                case C5419R.id.role_settings_moderate_member /* 2131364992 */:
                    j = Permission.MODERATE_MEMBERS;
                    break;
                case C5419R.id.role_settings_priority_speaker /* 2131364994 */:
                    j = 256;
                    break;
                case C5419R.id.role_settings_read_message_history /* 2131364995 */:
                    j = Permission.READ_MESSAGE_HISTORY;
                    break;
                case C5419R.id.role_settings_read_messages /* 2131364996 */:
                    j = Permission.VIEW_CHANNEL;
                    break;
                case C5419R.id.role_settings_request_to_speak /* 2131364997 */:
                    j = Permission.REQUEST_TO_SPEAK;
                    break;
                case C5419R.id.role_settings_send_messages /* 2131365001 */:
                    j = Permission.SEND_MESSAGES;
                    break;
                case C5419R.id.role_settings_send_messages_in_threads /* 2131365002 */:
                    j = Permission.SEND_MESSAGES_IN_THREADS;
                    break;
                case C5419R.id.role_settings_send_tts_messages /* 2131365003 */:
                    j = Permission.SEND_TTS_MESSAGES;
                    break;
                case C5419R.id.role_settings_use_application_commands /* 2131365004 */:
                    j = Permission.USE_APPLICATION_COMMANDS;
                    break;
                case C5419R.id.role_settings_use_external_emojis /* 2131365005 */:
                    j = Permission.USE_EXTERNAL_EMOJIS;
                    break;
                case C5419R.id.role_settings_use_external_stickers /* 2131365006 */:
                    j = Permission.USE_EXTERNAL_STICKERS;
                    break;
                case C5419R.id.role_settings_view_audit_log /* 2131365007 */:
                    j = 128;
                    break;
                case C5419R.id.role_settings_view_guild_analytics /* 2131365008 */:
                    j = Permission.VIEW_GUILD_ANALYTICS;
                    break;
                case C5419R.id.role_settings_voice_connect /* 2131365009 */:
                    j = Permission.CONNECT;
                    break;
                case C5419R.id.role_settings_voice_deafen_members /* 2131365010 */:
                    j = Permission.DEAFEN_MEMBERS;
                    break;
                case C5419R.id.role_settings_voice_move_members /* 2131365011 */:
                    j = Permission.MOVE_MEMBERS;
                    break;
                case C5419R.id.role_settings_voice_mute_members /* 2131365012 */:
                    j = Permission.MUTE_MEMBERS;
                    break;
                case C5419R.id.role_settings_voice_speak /* 2131365013 */:
                    j = Permission.SPEAK;
                    break;
                case C5419R.id.role_settings_voice_use_voice_activity /* 2131365014 */:
                    j = Permission.USE_VAD;
                    break;
                case C5419R.id.role_settings_voice_video /* 2131365015 */:
                    j = 512;
                    break;
            }
            boolean zCan = PermissionUtils.can(j, Long.valueOf(data.getRole().getPermissions()));
            checkedSetting.setChecked(zCan);
            boolean zCan2 = PermissionUtils.can(j, data.getMyPermissions());
            Model.ManageStatus manageStatus = data.getManageStatus();
            if (manageStatus != null) {
                int iOrdinal = manageStatus.ordinal();
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        checkedSetting.m8526c(getLockMessage(data, false));
                    } else if (!data.getOwner() && j == 8 && data.isSingular(j)) {
                        checkedSetting.m8525b(C5419R.string.help_singular_permission);
                    } else {
                        enableSetting(checkedSetting, data, j);
                    }
                } else if (zCan2 && !(data.isSingular(j) && zCan)) {
                    enableSetting(checkedSetting, data, j);
                } else if (zCan2) {
                    checkedSetting.m8525b(C5419R.string.help_singular_permission);
                } else {
                    checkedSetting.m8525b(C5419R.string.help_missing_permission);
                }
            }
            checkedSetting.setVisibility(((j > Permission.VIEW_GUILD_ANALYTICS ? 1 : (j == Permission.VIEW_GUILD_ANALYTICS ? 0 : -1)) == 0 && !data.isCommunityServer()) ^ true ? 0 : 8);
        }
        CheckedSetting checkedSetting2 = getBinding().f16502E;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsModerateMember");
        checkedSetting2.setVisibility(data.getHasGuildCommunicationDisabledFeature() ? 0 : 8);
    }

    private final void setupRoleName(Model data) {
        TextInputLayout textInputLayout = getBinding().f16526b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f16526b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), data.getRole().getName()));
        if (!data.canManage() || data.isEveryoneRole()) {
            View view = getBinding().f16539o;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.roleSettingsEditNameDisabledOverlay");
            view.setVisibility(0);
            getBinding().f16539o.setOnClickListener(new ViewOnClickListenerC92461(data));
            return;
        }
        View view2 = getBinding().f16539o;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.roleSettingsEditNameDisabledOverlay");
        view2.setVisibility(8);
        getBinding().f16539o.setOnClickListener(null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f16527c;
        TextInputLayout textInputLayout = getBinding().f16526b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        FloatingActionButton floatingActionButton2 = getBinding().f16527c;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton2, "binding.editRoleSave");
        floatingActionButton2.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L), getMostRecentIntent().getLongExtra(INTENT_EXTRA_ROLE_ID, -1L))), this, null, 2, null), WidgetServerSettingsEditRole.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C92381(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
