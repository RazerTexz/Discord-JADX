package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.auth.mfa.BackupCode;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyResponse;
import com.discord.api.auth.mfa.GetBackupCodesVerificationRequestBody;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* compiled from: WidgetSettingsAccountBackupCodes.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAccountBackupCodes.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter backupCodesAdapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String nonce;
    private String password;
    private String regenerateNonce;
    private String verificationKey;

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {

        /* compiled from: WidgetSettingsAccountBackupCodes.kt */
        public static final class BackupCodeHeaderViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeHeaderBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeHeaderViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeHeaderBinding widgetSettingsItemBackupCodeHeaderBinding = new WidgetSettingsItemBackupCodeHeaderBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeHeaderBinding, "WidgetSettingsItemBackup…derBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeHeaderBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
                onConfigure2(i, mGRecyclerDataPayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.f17978b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemHeader");
                textView.setText(((BackupCodeItemHeader) data).getHeaderText());
            }
        }

        /* compiled from: WidgetSettingsAccountBackupCodes.kt */
        public static final class BackupCodeViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeBinding widgetSettingsItemBackupCodeBinding = new WidgetSettingsItemBackupCodeBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeBinding, "WidgetSettingsItemBackupCodeBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
                onConfigure2(i, mGRecyclerDataPayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                BackupCodeItem backupCodeItem = (BackupCodeItem) data;
                TextView textView = this.binding.f17976b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemBackupCodeTv");
                String code = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = code.substring(0, 4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String code2 = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = code2.substring(4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                FormatUtils.m222n(textView, C5419R.string.backup_codes_dash, new Object[]{strSubstring, strSubstring2}, null, 4);
                if (backupCodeItem.getBackupCode().getConsumed()) {
                    this.binding.f17976b.setCompoundDrawablesWithIntrinsicBounds(0, 0, C5419R.drawable.ic_check_brand_24dp, 0);
                    this.binding.f17976b.setOnClickListener(null);
                } else {
                    this.binding.f17976b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.binding.f17976b.setOnClickListener(new WidgetSettingsAccountBackupCodes2(data));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return viewType != 0 ? viewType != 1 ? new MGRecyclerViewHolder<>(0, this) : new BackupCodeViewHolder(C5419R.layout.widget_settings_item_backup_code, this) : new BackupCodeHeaderViewHolder(C5419R.layout.widget_settings_item_backup_code_header, this);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final /* data */ class BackupCodeItem implements MGRecyclerDataPayload {
        private final BackupCode backupCode;
        private final String key;
        private final int type;

        public BackupCodeItem(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            this.backupCode = backupCode;
            this.type = 1;
            this.key = backupCode.getCode();
        }

        public static /* synthetic */ BackupCodeItem copy$default(BackupCodeItem backupCodeItem, BackupCode backupCode, int i, Object obj) {
            if ((i & 1) != 0) {
                backupCode = backupCodeItem.backupCode;
            }
            return backupCodeItem.copy(backupCode);
        }

        /* renamed from: component1, reason: from getter */
        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        public final BackupCodeItem copy(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            return new BackupCodeItem(backupCode);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItem) && Intrinsics3.areEqual(this.backupCode, ((BackupCodeItem) other).backupCode);
            }
            return true;
        }

        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            BackupCode backupCode = this.backupCode;
            if (backupCode != null) {
                return backupCode.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("BackupCodeItem(backupCode=");
            sbM833U.append(this.backupCode);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final /* data */ class BackupCodeItemHeader implements MGRecyclerDataPayload {
        private final CharSequence headerText;
        private final String key;
        private final int type;

        public BackupCodeItemHeader(CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            this.headerText = charSequence;
            this.key = charSequence.toString();
        }

        public static /* synthetic */ BackupCodeItemHeader copy$default(BackupCodeItemHeader backupCodeItemHeader, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = backupCodeItemHeader.headerText;
            }
            return backupCodeItemHeader.copy(charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        public final BackupCodeItemHeader copy(CharSequence headerText) {
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            return new BackupCodeItemHeader(headerText);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItemHeader) && Intrinsics3.areEqual(this.headerText, ((BackupCodeItemHeader) other).headerText);
            }
            return true;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            CharSequence charSequence = this.headerText;
            if (charSequence != null) {
                return charSequence.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.m817E(outline.m833U("BackupCodeItemHeader(headerText="), this.headerText, ")");
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m156d(context, WidgetSettingsAccountBackupCodes.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$getBackupCodes$1 */
    public static final class C97341 extends Lambda implements Function1<GetBackupCodesResponse, Unit> {
        public C97341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesResponse getBackupCodesResponse) {
            invoke2(getBackupCodesResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesResponse getBackupCodesResponse) {
            List<BackupCode> listM7590a = getBackupCodesResponse.m7590a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listM7590a) {
                if (!((BackupCode) obj).getConsumed()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listM7590a) {
                if (((BackupCode) obj2).getConsumed()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            if (!arrayList.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.m216h(WidgetSettingsAccountBackupCodes.this.requireContext(), C5419R.string.user_settings_available_codes, new Object[0], null, 4)));
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList4.add(new BackupCodeItem((BackupCode) it.next()));
                }
                arrayList3.addAll(arrayList4);
            }
            if (!arrayList2.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.m216h(WidgetSettingsAccountBackupCodes.this.requireContext(), C5419R.string.user_settings_used_backup_codes, new Object[0], null, 4)));
                ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(new BackupCodeItem((BackupCode) it2.next()));
                }
                arrayList3.addAll(arrayList5);
            }
            WidgetSettingsAccountBackupCodes.access$configureUI(WidgetSettingsAccountBackupCodes.this, arrayList3);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$onViewBound$2 */
    public static final class ViewOnClickListenerC97352 implements View.OnClickListener {
        public ViewOnClickListenerC97352() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountBackupCodes.access$getBackupCodes(WidgetSettingsAccountBackupCodes.this, true);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$sendVerificationKey$1 */
    public static final class C97361 extends Lambda implements Function1<GetBackupCodesSendVerificationKeyResponse, Unit> {
        public C97361() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            invoke2(getBackupCodesSendVerificationKeyResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            WidgetSettingsAccountBackupCodes.access$setNonce$p(WidgetSettingsAccountBackupCodes.this, getBackupCodesSendVerificationKeyResponse.getNonce());
            WidgetSettingsAccountBackupCodes.access$setRegenerateNonce$p(WidgetSettingsAccountBackupCodes.this, getBackupCodesSendVerificationKeyResponse.getRegenerateNonce());
            WidgetSettingsAccountBackupCodes.access$showVerificationKeyModal(WidgetSettingsAccountBackupCodes.this);
        }
    }

    /* compiled from: WidgetSettingsAccountBackupCodes.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$sendVerificationKey$2 */
    public static final class C97372<T> implements Action1<Error> {
        public C97372() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetSettingsAccountBackupCodes.access$showPasswordModal(WidgetSettingsAccountBackupCodes.this);
        }
    }

    public WidgetSettingsAccountBackupCodes() {
        super(C5419R.layout.widget_settings_account_backup_codes);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountBackupCodes3.INSTANCE, null, 2, null);
        this.password = "";
        this.nonce = "";
        this.regenerateNonce = "";
        this.verificationKey = "";
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, List list) {
        widgetSettingsAccountBackupCodes.configureUI(list);
    }

    public static final /* synthetic */ void access$getBackupCodes(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2) {
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    public static final /* synthetic */ String access$getNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.nonce;
    }

    public static final /* synthetic */ String access$getPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.password;
    }

    public static final /* synthetic */ String access$getRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.regenerateNonce;
    }

    public static final /* synthetic */ String access$getVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.verificationKey;
    }

    public static final /* synthetic */ void access$sendVerificationKey(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.sendVerificationKey();
    }

    public static final /* synthetic */ void access$setNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.nonce = str;
    }

    public static final /* synthetic */ void access$setPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.password = str;
    }

    public static final /* synthetic */ void access$setRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.regenerateNonce = str;
    }

    public static final /* synthetic */ void access$setVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.verificationKey = str;
    }

    public static final /* synthetic */ void access$showPasswordModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showPasswordModal();
    }

    public static final /* synthetic */ void access$showVerificationKeyModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showVerificationKeyModal();
    }

    private final void configureUI(List<? extends MGRecyclerDataPayload> data) {
        Adapter adapter = this.backupCodesAdapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("backupCodesAdapter");
        }
        adapter.setData(data);
    }

    private final void getBackupCodes(boolean regenerate) {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesVerification(new GetBackupCodesVerificationRequestBody(this.verificationKey, regenerate ? this.regenerateNonce : this.nonce, regenerate)), this, null, 2, null), getBinding().f17781b, 100L), false, 1, null).m11108k(C0879o.f566a.m184g(getContext(), new C97341(), null));
    }

    public static /* synthetic */ void getBackupCodes$default(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    private final WidgetSettingsAccountBackupCodesBinding getBinding() {
        return (WidgetSettingsAccountBackupCodesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendVerificationKey() {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesSendVerificationKey(new GetBackupCodesSendVerificationKeyRequestBody(this.password)), this, null, 2, null), false, 1, null).m11108k(C0879o.f566a.m184g(getContext(), new C97361(), new C97372()));
    }

    private final void showPasswordModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            CharSequence charSequenceM216h = FormatUtils.m216h(requireContext(), C5419R.string.user_settings_enter_password_view_codes, new Object[0], null, 4);
            CharSequence charSequenceM216h2 = FormatUtils.m216h(requireContext(), C5419R.string.form_label_password, new Object[0], null, 4);
            WidgetNoticeDialog.Companion.showInputModal$default(companion, appActivity, FormatUtils.m216h(requireContext(), C5419R.string.two_fa_backup_codes_label, new Object[0], null, 4), charSequenceM216h, charSequenceM216h2, new WidgetSettingsAccountBackupCodes4(this), new WidgetSettingsAccountBackupCodes5(this), Boolean.FALSE, null, FormatUtils.m216h(requireContext(), C5419R.string.two_fa_backup_codes_next_action, new Object[0], null, 4), false, 640, null);
        }
    }

    private final void showVerificationKeyModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.Companion.showInputModal$default(WidgetNoticeDialog.INSTANCE, appActivity, FormatUtils.m216h(requireContext(), C5419R.string.two_fa_confirm_view_backup_codes_label, new Object[0], null, 4), FormatUtils.m216h(requireContext(), C5419R.string.two_fa_confirm_view_backup_codes_body, new Object[0], null, 4), FormatUtils.m216h(requireContext(), C5419R.string.two_fa_confirm_view_backup_codes_input_label, new Object[0], null, 4), new WidgetSettingsAccountBackupCodes6(this), new WidgetSettingsAccountBackupCodes7(this), Boolean.FALSE, StoreNotices.InputDialog.Type.TEXT_NO_SUGGESTIONS, null, true, 256, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.two_fa_backup_codes_label);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f17783d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsBackupCodesInfo");
        FormatUtils.m222n(textView, C5419R.string.two_fa_backup_codes_body, new Object[0], null, 4);
        RecyclerView recyclerView = getBinding().f17784e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBackupCodesRv");
        this.backupCodesAdapter = new Adapter(recyclerView);
        if (getActivity() != null) {
            MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
            RecyclerView recyclerView2 = getBinding().f17784e;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBackupCodesRv");
            this.backupCodesAdapter = (Adapter) companion.configure(new Adapter(recyclerView2));
        }
        getBinding().f17782c.setOnClickListener(new ViewOnClickListenerC97352());
        getBinding().f17781b.setDimmed(true, true);
        showPasswordModal();
    }
}
