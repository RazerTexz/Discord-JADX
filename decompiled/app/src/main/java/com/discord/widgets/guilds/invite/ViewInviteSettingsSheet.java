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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildInviteBottomSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.views.CheckedSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import p007b.p008a.p025i.ViewRadioButtonBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

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
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$1 */
    public static final class C86391 extends Lambda implements Function1<Integer, CharSequence> {
        public C86391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            Context context = ViewInviteSettingsSheet.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return DurationUtils3.formatInviteExpireAfterString(context, i);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$2 */
    public static final /* synthetic */ class C86402 extends FunctionReferenceImpl implements Function1<Integer, String> {
        public C86402(ViewInviteSettingsSheet viewInviteSettingsSheet) {
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
            Intrinsics3.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new ViewInviteSettingsSheet2(dropDownMode).invoke2());
            Intrinsics3.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.m7679c(this.channels[position])}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, C5419R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, C5419R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            Intrinsics3.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channelArr, "channels");
            this.channels = channelArr;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Channel getItem(int position) {
            return this.channels[position];
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$10 */
    public static final class ViewOnClickListenerC864110 implements View.OnClickListener {
        public final /* synthetic */ WidgetInviteModel $data;

        public ViewOnClickListenerC864110(WidgetInviteModel widgetInviteModel) {
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
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$4 */
    public static final class C86424 implements RadioGroup.OnCheckedChangeListener {
        public C86424() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxAge(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$8 */
    public static final class C86438 implements RadioGroup.OnCheckedChangeListener {
        public C86438() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsAccess$getPendingInviteSettings$p != null ? settingsAccess$getPendingInviteSettings$p.mergeMaxUses(i) : null);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$configureUi$9 */
    public static final class ViewOnClickListenerC86449 implements View.OnClickListener {
        public ViewOnClickListenerC86449() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite.Settings settingsMergeTemporary;
            ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f15457f.toggle();
            ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
            ModelInvite.Settings settingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
            if (settingsAccess$getPendingInviteSettings$p != null) {
                CheckedSetting checkedSetting = ViewInviteSettingsSheet.access$getBinding$p(ViewInviteSettingsSheet.this).f15457f;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
                settingsMergeTemporary = settingsAccess$getPendingInviteSettings$p.mergeTemporary(checkedSetting.isChecked());
            } else {
                settingsMergeTemporary = null;
            }
            ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, settingsMergeTemporary);
        }
    }

    /* compiled from: ViewInviteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$setOnItemSelected$1 */
    public static final class C86451 implements AdapterView.OnItemSelectedListener {
        public C86451() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            ViewInviteSettingsSheet.this.getViewModel().selectChannel(ViewInviteSettingsSheet.access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet.this).getItem(position).getId());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.m218j(this, C5419R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
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
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            RadioButton radioButton = (RadioButton) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new ViewRadioButtonBinding(radioButton), "ViewRadioButtonBinding.i…text), radioGroup, false)");
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setId(i);
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = radioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.root");
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
        Spinner spinner = this.binding.f15453b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new C86451());
    }

    public final void configureUi(WidgetInviteModel data) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(data, "data");
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
        this.binding.f15453b.setSelection(Math.max(i, 0), false);
        ModelInvite.Settings settings = data.getSettings();
        if (settings != null) {
            this.pendingInviteSettings = settings;
            RadioGroup radioGroup = this.binding.f15454c;
            Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
            Ranges2 ranges2Until = _Ranges.until(0, radioGroup.getChildCount());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
            Iterator<Integer> it2 = ranges2Until.iterator();
            while (it2.hasNext()) {
                View childAt = this.binding.f15454c.getChildAt(((Iterators4) it2).nextInt());
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
            this.binding.f15454c.setOnCheckedChangeListener(new C86424());
            RadioGroup radioGroup2 = this.binding.f15456e;
            Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
            Ranges2 ranges2Until2 = _Ranges.until(0, radioGroup2.getChildCount());
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until2, 10));
            Iterator<Integer> it4 = ranges2Until2.iterator();
            while (it4.hasNext()) {
                View childAt2 = this.binding.f15456e.getChildAt(((Iterators4) it4).nextInt());
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
            this.binding.f15456e.setOnCheckedChangeListener(new C86438());
            CheckedSetting checkedSetting = this.binding.f15457f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite.Settings settings4 = this.pendingInviteSettings;
            checkedSetting.setChecked(settings4 != null ? settings4.isTemporary() : false);
            this.binding.f15457f.m8527e(new ViewOnClickListenerC86449());
            this.binding.f15455d.setOnClickListener(new ViewOnClickListenerC864110(data));
        }
    }

    public final Function0<Unit> getOnGenerateLinkListener() {
        return this.onGenerateLinkListener;
    }

    public final WidgetGuildInviteShareViewModel getViewModel() {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.viewModel;
        if (widgetGuildInviteShareViewModel == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("viewModel");
        }
        return widgetGuildInviteShareViewModel;
    }

    public final void setOnGenerateLinkListener(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onGenerateLinkListener = function0;
    }

    public final void setViewModel(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        Intrinsics3.checkNotNullParameter(widgetGuildInviteShareViewModel, "<set-?>");
        this.viewModel = widgetGuildInviteShareViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.m218j(this, C5419R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
        setOnItemSelected();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet4.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet3.INSTANCE;
        setFocusable(true);
        setContentDescription(FormatUtils.m218j(this, C5419R.string.invite_settings_title, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
        setOnItemSelected();
    }
}
