package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.widget.NestedScrollView;
import b.a.i.d3;
import b.a.k.b;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildInviteBottomSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.views.CheckedSetting;
import d0.d0.f;
import d0.t.c0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: ViewInviteSettingsSheet.kt */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet extends NestedScrollView {
    private final ViewGuildInviteBottomSheetBinding binding;
    private final ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private Function0<Unit> onGenerateLinkListener;
    private ModelInvite.Settings pendingInviteSettings;
    private Function1<? super ModelInvite.Settings, Unit> updateSettings;
    public WidgetGuildInviteShareViewModel viewModel;

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, CharSequence> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            Context context = ViewInviteSettingsSheet.this.getContext();
            m.checkNotNullExpressionValue(context, "context");
            return DurationUtilsKt.formatInviteExpireAfterString(context, i);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<Integer, String> {
        public AnonymousClass2(ViewInviteSettingsSheet viewInviteSettingsSheet) {
            super(1, viewInviteSettingsSheet, ViewInviteSettingsSheet.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return ViewInviteSettingsSheet.access$getMaxUsesString((ViewInviteSettingsSheet) this.receiver, i);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    public static final class ChannelsSpinnerAdapter extends ArrayAdapter<Channel> {
        private Channel[] channels;

        public /* synthetic */ ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, i, (i2 & 4) != 0 ? new Channel[0] : channelArr);
        }

        private final View getItemView(int position, int layoutId, View convertView, boolean dropDownMode) {
            if (convertView == null) {
                convertView = View.inflate(getContext(), layoutId, null);
            }
            m.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new ViewInviteSettingsSheet$ChannelsSpinnerAdapter$setupViews$1(dropDownMode).invoke2());
            m.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.c(this.channels[position])}, 1));
            m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            m.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            m.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            m.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(channelArr, "channels");
            this.channels = channelArr;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Channel getItem(int position) {
            return this.channels[position];
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ WidgetInviteModel $data;

        public AnonymousClass10(WidgetInviteModel widgetInviteModel) {
            this.$data = widgetInviteModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(ViewInviteSettingsSheet.this);
            if (settingsAccess$getPendingInviteSettings$p != null) {
                ViewInviteSettingsSheet.this.getViewModel().updateInviteSettings(settingsAccess$getPendingInviteSettings$p);
            }
            Channel targetChannel = this.$data.getTargetChannel();
            if (targetChannel != null) {
                ViewInviteSettingsSheet.this.getViewModel().generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
            }
            ViewInviteSettingsSheet.this.getOnGenerateLinkListener().invoke();
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 implements RadioGroup.OnCheckedChangeListener {
        public AnonymousClass4() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxAge(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$8, reason: invalid class name */
    public static final class AnonymousClass8 implements RadioGroup.OnCheckedChangeListener {
        public AnonymousClass8() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxUses(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite.Settings settingsMergeTemporary;
            ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f.toggle();
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            if (settingsAccess$getPendingInviteSettings$p != null) {
                CheckedSetting checkedSetting = ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f;
                m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
                settingsMergeTemporary = settingsAccess$getPendingInviteSettings$p.mergeTemporary(checkedSetting.isChecked());
            } else {
                settingsMergeTemporary = null;
            }
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsMergeTemporary);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$setOnItemSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AdapterView.OnItemSelectedListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            m.checkNotNullParameter(parent, "parent");
            m.checkNotNullParameter(view, "view");
            ViewInviteSettingsSheet.this.getViewModel().selectChannel(ViewInviteSettingsSheet.access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet.this).getItem(position).getId());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
            m.checkNotNullParameter(parent, "parent");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context) {
        super(context);
        m.checkNotNullParameter(context, "ctx");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    public static final /* synthetic */ ViewGuildInviteBottomSheetBinding access$getBinding$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.binding;
    }

    public static final /* synthetic */ ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.channelsSpinnerAdapter;
    }

    public static final /* synthetic */ String access$getMaxUsesString(ViewInviteSettingsSheet viewInviteSettingsSheet, int i) {
        return viewInviteSettingsSheet.getMaxUsesString(i);
    }

    public static final /* synthetic */ ModelInvite.Settings access$getPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.pendingInviteSettings;
    }

    public static final /* synthetic */ void access$setPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet, ModelInvite.Settings settings) {
        viewInviteSettingsSheet.pendingInviteSettings = settings;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            RadioButton radioButton = (RadioButton) viewInflate;
            m.checkNotNullExpressionValue(new d3(radioButton), "ViewRadioButtonBinding.i…text), radioGroup, false)");
            m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setId(i);
            m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                m.checkNotNullExpressionValue(radioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = radioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                m.checkNotNullExpressionValue(radioButton, "binding.root");
                radioButton.setLayoutParams(layoutParams2);
                z2 = true;
            }
            radioGroup.addView(radioButton);
        }
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final void setOnItemSelected() {
        Spinner spinner = this.binding.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AnonymousClass1());
    }

    public final void configureUi(WidgetInviteModel data) {
        Object obj;
        Object next;
        m.checkNotNullParameter(data, "data");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        Object[] array = data.getInvitableChannels().toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        channelsSpinnerAdapter.setData((Channel[]) array);
        Iterator<Channel> it = data.getInvitableChannels().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Channel next2 = it.next();
            Channel targetChannel = data.getTargetChannel();
            if (targetChannel != null && targetChannel.getId() == next2.getId()) {
                break;
            } else {
                i++;
            }
        }
        this.binding.f2190b.setSelection(Math.max(i, 0), false);
        ModelInvite.Settings settings = data.getSettings();
        if (settings != null) {
            this.pendingInviteSettings = settings;
            RadioGroup radioGroup = this.binding.c;
            m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
            IntRange intRangeUntil = f.until(0, radioGroup.getChildCount());
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                View childAt = this.binding.c.getChildAt(((c0) it2).nextInt());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList.add((RadioButton) childAt);
            }
            Iterator it3 = arrayList.iterator();
            while (true) {
                obj = null;
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                int id2 = ((RadioButton) next).getId();
                ModelInvite.Settings settings2 = this.pendingInviteSettings;
                if (settings2 != null && id2 == settings2.getMaxAge()) {
                    break;
                }
            }
            RadioButton radioButton = (RadioButton) next;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            this.binding.c.setOnCheckedChangeListener(new AnonymousClass4());
            RadioGroup radioGroup2 = this.binding.e;
            m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
            IntRange intRangeUntil2 = f.until(0, radioGroup2.getChildCount());
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it4 = intRangeUntil2.iterator();
            while (it4.hasNext()) {
                View childAt2 = this.binding.e.getChildAt(((c0) it4).nextInt());
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList2.add((RadioButton) childAt2);
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next3 = it5.next();
                int id3 = ((RadioButton) next3).getId();
                ModelInvite.Settings settings3 = this.pendingInviteSettings;
                if (settings3 != null && id3 == settings3.getMaxUses()) {
                    obj = next3;
                    break;
                }
            }
            RadioButton radioButton2 = (RadioButton) obj;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
            this.binding.e.setOnCheckedChangeListener(new AnonymousClass8());
            CheckedSetting checkedSetting = this.binding.f;
            m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite.Settings settings4 = this.pendingInviteSettings;
            checkedSetting.setChecked(settings4 != null ? settings4.isTemporary() : false);
            this.binding.f.e(new AnonymousClass9());
            this.binding.d.setOnClickListener(new AnonymousClass10(data));
        }
    }

    public final Function0<Unit> getOnGenerateLinkListener() {
        return this.onGenerateLinkListener;
    }

    public final WidgetGuildInviteShareViewModel getViewModel() {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.viewModel;
        if (widgetGuildInviteShareViewModel == null) {
            m.throwUninitializedPropertyAccessException("viewModel");
        }
        return widgetGuildInviteShareViewModel;
    }

    public final void setOnGenerateLinkListener(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onGenerateLinkListener = function0;
    }

    public final void setViewModel(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        m.checkNotNullParameter(widgetGuildInviteShareViewModel, "<set-?>");
        this.viewModel = widgetGuildInviteShareViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "ctx");
        m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "ctx");
        m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }
}
