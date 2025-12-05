package com.discord.widgets.servers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsIntegrationListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.WidgetServerSettingsConfirmDisableIntegrationBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem extends MGRecyclerViewHolder<WidgetServerSettingsIntegrations.Adapter, WidgetServerSettingsIntegrations.Model.IntegrationItem> {
    private final WidgetServerSettingsIntegrationListItemBinding binding;

    /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$onConfigure$1 */
    public static final class ViewOnClickListenerC92651 implements View.OnClickListener {
        public final /* synthetic */ long $integrationId;

        public ViewOnClickListenerC92651(long j) {
            this.$integrationId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsIntegrationsListItem.access$getAdapter$p(WidgetServerSettingsIntegrationsListItem.this).onIntegrationSelected(this.$integrationId);
        }
    }

    /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$onConfigure$2 */
    public static final class C92662<T> implements Action1<Boolean> {
        public final /* synthetic */ WidgetServerSettingsIntegrations.Model.IntegrationItem $data;
        public final /* synthetic */ long $integrationId;
        public final /* synthetic */ boolean $isTwitch;

        /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$onConfigure$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r3) {
                CheckedSetting checkedSetting = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(WidgetServerSettingsIntegrationsListItem.this).f17697h;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
                checkedSetting.setChecked(true);
                CheckedSetting checkedSetting2 = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(WidgetServerSettingsIntegrationsListItem.this).f17697h;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
                checkedSetting2.setEnabled(false);
                WidgetServerSettingsIntegrationsListItem.access$showSyncingUI(WidgetServerSettingsIntegrationsListItem.this, true);
            }
        }

        public C92662(WidgetServerSettingsIntegrations.Model.IntegrationItem integrationItem, long j, boolean z2) {
            this.$data = integrationItem;
            this.$integrationId = j;
            this.$isTwitch = z2;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            if (!bool.booleanValue()) {
                Observable observableM8518ui = ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableIntegration(this.$data.getGuildId(), new RestAPIParams.EnableIntegration(this.$data.getIntegration().getType(), String.valueOf(this.$integrationId))), false, 1, null));
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                CheckedSetting checkedSetting = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(WidgetServerSettingsIntegrationsListItem.this).f17697h;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
                observableM8518ui.m11108k(C0879o.m183j(anonymousClass1, checkedSetting.getContext(), null, 4));
                return;
            }
            WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem = WidgetServerSettingsIntegrationsListItem.this;
            long guildId = this.$data.getGuildId();
            long j = this.$integrationId;
            boolean z2 = this.$isTwitch;
            CheckedSetting checkedSetting2 = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(WidgetServerSettingsIntegrationsListItem.this).f17697h;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
            Context context = checkedSetting2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.integrationSyncSwitch.context");
            WidgetServerSettingsIntegrationsListItem.access$showDisableSyncDialog(widgetServerSettingsIntegrationsListItem, guildId, j, z2, context);
        }
    }

    /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$1 */
    public static final class ViewOnClickListenerC92671 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC92671(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2 */
    public static final class ViewOnClickListenerC92682 implements View.OnClickListener {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AlertDialog $dialog;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $integrationId;

        /* compiled from: WidgetServerSettingsIntegrationsListItem.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Void> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r1) {
                ViewOnClickListenerC92682.this.$dialog.dismiss();
            }
        }

        public ViewOnClickListenerC92682(long j, long j2, AlertDialog alertDialog, Context context) {
            this.$guildId = j;
            this.$integrationId = j2;
            this.$dialog = alertDialog;
            this.$context = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildIntegration(this.$guildId, this.$integrationId), false, 1, null)).m11108k(C0879o.m183j(new AnonymousClass1(), this.$context, null, 4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsIntegrationsListItem(WidgetServerSettingsIntegrations.Adapter adapter) {
        super(C5419R.layout.widget_server_settings_integration_list_item, adapter);
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.integration_header_container;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.integration_header_container);
        if (relativeLayout != null) {
            i = C5419R.id.integration_header_disabled_overlay;
            View viewFindViewById = view.findViewById(C5419R.id.integration_header_disabled_overlay);
            if (viewFindViewById != null) {
                i = C5419R.id.integration_icon;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.integration_icon);
                if (imageView != null) {
                    i = C5419R.id.integration_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.integration_name);
                    if (textView != null) {
                        i = C5419R.id.integration_name_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.integration_name_container);
                        if (linearLayout != null) {
                            i = C5419R.id.integration_owner_name;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.integration_owner_name);
                            if (textView2 != null) {
                                i = C5419R.id.integration_settings_icon;
                                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.integration_settings_icon);
                                if (imageView2 != null) {
                                    i = C5419R.id.integration_sync_switch;
                                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.integration_sync_switch);
                                    if (checkedSetting != null) {
                                        i = C5419R.id.integration_syncing_progress_bar;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.integration_syncing_progress_bar);
                                        if (progressBar != null) {
                                            WidgetServerSettingsIntegrationListItemBinding widgetServerSettingsIntegrationListItemBinding = new WidgetServerSettingsIntegrationListItemBinding((FrameLayout) view, relativeLayout, viewFindViewById, imageView, textView, linearLayout, textView2, imageView2, checkedSetting, progressBar);
                                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsIntegrationListItemBinding, "WidgetServerSettingsInte…temBinding.bind(itemView)");
                                            this.binding = widgetServerSettingsIntegrationListItemBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsIntegrations.Adapter access$getAdapter$p(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem) {
        return (WidgetServerSettingsIntegrations.Adapter) widgetServerSettingsIntegrationsListItem.adapter;
    }

    public static final /* synthetic */ WidgetServerSettingsIntegrationListItemBinding access$getBinding$p(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem) {
        return widgetServerSettingsIntegrationsListItem.binding;
    }

    public static final /* synthetic */ void access$showDisableSyncDialog(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, long j, long j2, boolean z2, Context context) {
        widgetServerSettingsIntegrationsListItem.showDisableSyncDialog(j, j2, z2, context);
    }

    public static final /* synthetic */ void access$showSyncingUI(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, boolean z2) {
        widgetServerSettingsIntegrationsListItem.showSyncingUI(z2);
    }

    private final void showDisableSyncDialog(long guildId, long integrationId, boolean isTwitch, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.widget_server_settings_confirm_disable_integration, (ViewGroup) null, false);
        int i = C5419R.id.server_settings_confirm_disable_integration_body;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.server_settings_confirm_disable_integration_body);
        if (textView != null) {
            i = C5419R.id.server_settings_confirm_disable_integration_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.server_settings_confirm_disable_integration_cancel);
            if (materialButton != null) {
                i = C5419R.id.server_settings_confirm_disable_integration_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.server_settings_confirm_disable_integration_confirm);
                if (materialButton2 != null) {
                    i = C5419R.id.server_settings_confirm_disable_integration_header;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.server_settings_confirm_disable_integration_header);
                    if (textView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new WidgetServerSettingsConfirmDisableIntegrationBinding(linearLayout, textView, materialButton, materialButton2, textView2), "WidgetServerSettingsConf…om(context), null, false)");
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(cont…ew(binding.root).create()");
                        materialButton.setOnClickListener(new ViewOnClickListenerC92671(alertDialogCreate));
                        materialButton2.setOnClickListener(new ViewOnClickListenerC92682(guildId, integrationId, alertDialogCreate, context));
                        textView.setText(isTwitch ? C5419R.string.disable_integration_twitch_body : C5419R.string.disable_integration_youtube_body);
                        alertDialogCreate.show();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void showSyncingUI(boolean isSyncing) {
        ImageView imageView = this.binding.f17696g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.integrationSettingsIcon");
        imageView.setVisibility(isSyncing ^ true ? 0 : 8);
        ProgressBar progressBar = this.binding.f17698i;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.integrationSyncingProgressBar");
        progressBar.setVisibility(isSyncing ? 0 : 8);
        View view = this.binding.f17692c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(isSyncing ? 0 : 8);
        if (isSyncing) {
            this.binding.f17691b.setOnClickListener(null);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsIntegrations.Model.IntegrationItem integrationItem) {
        onConfigure2(i, integrationItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsIntegrations.Model.IntegrationItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        boolean zAreEqual = Intrinsics3.areEqual(data.getIntegration().getType(), "twitch");
        boolean zIsSyncing = data.getIntegration().isSyncing();
        boolean zIsEnabled = data.getIntegration().isEnabled();
        long id2 = data.getIntegration().getId();
        if (zIsSyncing) {
            this.binding.f17691b.setOnClickListener(null);
        } else {
            this.binding.f17691b.setOnClickListener(new ViewOnClickListenerC92651(id2));
        }
        TextView textView = this.binding.f17694e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.integrationName");
        textView.setText(data.getIntegration().getDisplayName());
        TextView textView2 = this.binding.f17695f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.integrationOwnerName");
        User user = data.getIntegration().getUser();
        textView2.setText(user != null ? user.getUsername() : null);
        this.binding.f17693d.setImageResource(zAreEqual ? C5419R.drawable.asset_account_sync_twitch : C5419R.drawable.asset_account_sync_youtube);
        View view = this.binding.f17692c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(zIsSyncing || !zIsEnabled ? 0 : 8);
        showSyncingUI(zIsSyncing);
        CheckedSetting checkedSetting = this.binding.f17697h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
        checkedSetting.setChecked(zIsEnabled);
        CheckedSetting checkedSetting2 = this.binding.f17697h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
        checkedSetting2.setEnabled(!zIsSyncing);
        if (zIsSyncing) {
            this.binding.f17697h.setOnCheckedListener(null);
        } else {
            this.binding.f17697h.setOnCheckedListener(new C92662(data, id2, zAreEqual));
        }
    }
}
