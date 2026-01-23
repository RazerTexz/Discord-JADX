package com.discord.widgets.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetSettingsAppearanceBinding;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.views.CheckedSetting;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.LazyJVM;
import p507d0.Result3;
import p507d0.p580t.Collections2;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAppearance.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAppearanceBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EASTER_EGG_UNLOCK_TIMEOUT = 5;
    private static final int HOLY_LIGHT_UNLOCK_COUNT = 5;
    private static final int PURE_EVIL_HINT_COUNT = 3;
    private static final int PURE_EVIL_UNLOCK_COUNT = 8;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicInteger holyLightEasterEggCounter;
    private final BehaviorSubject<Integer> newFontScaleSubject;
    private final AtomicInteger pureEvilEasterEggCounter;

    /* JADX INFO: renamed from: pureEvilEasterEggSubject$delegate, reason: from kotlin metadata */
    private final Lazy pureEvilEasterEggSubject;
    private ToastManager toastManager;

    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsAppearance.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canSeePureEvil;
        private final String currentTheme;
        private final int fontScale;
        private final MeUser meUser;

        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> easterEggPureEvil) {
                Intrinsics3.checkNotNullParameter(easterEggPureEvil, "easterEggPureEvil");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11075i = Observable.m11075i(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUserSettingsSystem().observeSettings(false), easterEggPureEvil, WidgetSettingsAppearance2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable\n            .…          )\n            }");
                return observableM11075i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(String str, boolean z2, int i, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(str, "currentTheme");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            this.currentTheme = str;
            this.canSeePureEvil = z2;
            this.fontScale = i;
            this.meUser = meUser;
        }

        public static /* synthetic */ Model copy$default(Model model, String str, boolean z2, int i, MeUser meUser, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = model.currentTheme;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canSeePureEvil;
            }
            if ((i2 & 4) != 0) {
                i = model.fontScale;
            }
            if ((i2 & 8) != 0) {
                meUser = model.meUser;
            }
            return model.copy(str, z2, i, meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFontScale() {
            return this.fontScale;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Model copy(String currentTheme, boolean canSeePureEvil, int fontScale, MeUser meUser) {
            Intrinsics3.checkNotNullParameter(currentTheme, "currentTheme");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            return new Model(currentTheme, canSeePureEvil, fontScale, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.currentTheme, model.currentTheme) && this.canSeePureEvil == model.canSeePureEvil && this.fontScale == model.fontScale && Intrinsics3.areEqual(this.meUser, model.meUser);
        }

        public final boolean getCanSeePureEvil() {
            return this.canSeePureEvil;
        }

        public final String getCurrentTheme() {
            return this.currentTheme;
        }

        public final int getFontScale() {
            return this.fontScale;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            String str = this.currentTheme;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.canSeePureEvil;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (((iHashCode + r2) * 31) + this.fontScale) * 31;
            MeUser meUser = this.meUser;
            return i + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(currentTheme=");
            sbM833U.append(this.currentTheme);
            sbM833U.append(", canSeePureEvil=");
            sbM833U.append(this.canSeePureEvil);
            sbM833U.append(", fontScale=");
            sbM833U.append(this.fontScale);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureThemeOption$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96271<T> implements Action1<Boolean> {
        public final /* synthetic */ String $settingTheme;

        public C96271(String str) {
            this.$settingTheme = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            if (bool.booleanValue()) {
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, this.$settingTheme);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class ViewOnClickListenerC96281 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        @DebugMetadata(m10084c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$1$1", m10085f = "WidgetSettingsAppearance.kt", m10086l = {122}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return ViewOnClickListenerC96281.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (C3404f.m4234P(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetSettingsAppearance.access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance.this).set(0);
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC96281() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).f17859l.m8529g(true, true);
            int andIncrement = WidgetSettingsAppearance.access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance.this).getAndIncrement();
            if (andIncrement != 0) {
                if (andIncrement != 5) {
                    return;
                }
                WidgetSettingsAppearance.access$showHolyLight(WidgetSettingsAppearance.this);
            } else {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
                if (coroutineScope != null) {
                    C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class ViewOnClickListenerC96292 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        @DebugMetadata(m10084c = "com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$2$1", m10085f = "WidgetSettingsAppearance.kt", m10086l = {Opcodes.F2I}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return ViewOnClickListenerC96292.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (C3404f.m4234P(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetSettingsAppearance.access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance.this).set(0);
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC96292(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).f17857j.m8529g(true, true);
            if (this.$model.getCanSeePureEvil()) {
                return;
            }
            int andIncrement = WidgetSettingsAppearance.access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance.this).getAndIncrement();
            if (andIncrement == 0) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
                if (coroutineScope != null) {
                    C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                    return;
                }
                return;
            }
            if (3 <= andIncrement && 8 > andIncrement) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                AppToast.m170h(view.getContext(), FormatUtils.m219k(WidgetSettingsAppearance.this, C5419R.string.theme_pure_evil_easter_hint, new Object[]{String.valueOf(8 - andIncrement)}, null, 4), 0, WidgetSettingsAppearance.access$getToastManager$p(WidgetSettingsAppearance.this), 4);
            } else if (andIncrement == 8) {
                AppToast.m166d(WidgetSettingsAppearance.this.getContext(), C5419R.string.theme_pure_evil_easter_reveal, 0, WidgetSettingsAppearance.access$getToastManager$p(WidgetSettingsAppearance.this));
                WidgetSettingsAppearance.access$getPureEvilEasterEggSubject$p(WidgetSettingsAppearance.this).onNext(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$3 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96303<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public C96303(Model model) {
            this.$model = model;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
            if (bool.booleanValue() && Intrinsics3.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_DARK)) {
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, ModelUserSettings.THEME_PURE_EVIL);
            } else {
                if (bool.booleanValue() || !Intrinsics3.areEqual(this.$model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
                    return;
                }
                WidgetSettingsAppearance.access$updateTheme(WidgetSettingsAppearance.this, ModelUserSettings.THEME_DARK);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$4 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96314 implements SeekBar.OnSeekBarChangeListener {
        public C96314() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                int i = progress + 80;
                WidgetSettingsAppearance.access$getNewFontScaleSubject$p(WidgetSettingsAppearance.this).onNext(Integer.valueOf(i));
                TextView textView = WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).f17851d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
                textView.setText(WidgetSettingsAppearance.access$getFontScaleString(WidgetSettingsAppearance.this, i, false));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$configureUI$5 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class ViewOnClickListenerC96325 implements View.OnClickListener {
        public static final ViewOnClickListenerC96325 INSTANCE = new ViewOnClickListenerC96325();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettingsSystem().setFontScale(-1);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final /* synthetic */ class C96331 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C96331(WidgetSettingsAppearance widgetSettingsAppearance) {
            super(1, widgetSettingsAppearance, WidgetSettingsAppearance.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSettingsAppearance.access$configureUI((WidgetSettingsAppearance) this.receiver, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96342 extends Lambda implements Function1<Integer, Unit> {
        public static final C96342 INSTANCE = new C96342();

        public C96342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(num, "fontScale");
            userSettingsSystem.setFontScale(num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96353<T> implements Action1<Boolean> {
        public static final C96353 INSTANCE = new C96353();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettingsSystem userSettingsSystem = StoreStream.INSTANCE.getUserSettingsSystem();
            Intrinsics3.checkNotNullExpressionValue(bool, "it");
            userSettingsSystem.setIsSyncThemeEnabled(bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$showHolyLight$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96361 extends Lambda implements Function1<Long, Unit> {
        public C96361() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            View view = WidgetSettingsAppearance.access$getBinding$p(WidgetSettingsAppearance.this).f17854g;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
            view.setVisibility(8);
            WidgetSettingsAppearance.access$tryEnableTorchMode(WidgetSettingsAppearance.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1 */
    /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
    public static final class C96371 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $theme;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$updateTheme$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
                invoke2(modelUserSettings);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserSettings modelUserSettings) {
                Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
                if (Intrinsics3.areEqual(C96371.this.$theme, ModelUserSettings.THEME_PURE_EVIL)) {
                    AppToast.m169g(WidgetSettingsAppearance.this.getActivity(), C5419R.string.theme_pure_evil_updated, 0, null, 12);
                } else {
                    AppToast.m169g(WidgetSettingsAppearance.this.getActivity(), C5419R.string.theme_updated, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96371(String str) {
            super(0);
            this.$theme = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithTheme(Intrinsics3.areEqual(this.$theme, ModelUserSettings.THEME_PURE_EVIL) ? ModelUserSettings.THEME_DARK : this.$theme)), false, 1, null), WidgetSettingsAppearance.this, null, 2, null), StoreUserSettings.class, WidgetSettingsAppearance.this.getActivity(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    public WidgetSettingsAppearance() {
        super(C5419R.layout.widget_settings_appearance);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAppearance3.INSTANCE, null, 2, null);
        this.newFontScaleSubject = BehaviorSubject.m11129k0();
        this.pureEvilEasterEggSubject = LazyJVM.lazy(WidgetSettingsAppearance4.INSTANCE);
        this.pureEvilEasterEggCounter = new AtomicInteger(0);
        this.holyLightEasterEggCounter = new AtomicInteger(0);
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAppearance widgetSettingsAppearance, Model model) {
        widgetSettingsAppearance.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsAppearanceBinding access$getBinding$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getBinding();
    }

    public static final /* synthetic */ String access$getFontScaleString(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2) {
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    public static final /* synthetic */ AtomicInteger access$getHolyLightEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.holyLightEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getNewFontScaleSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.newFontScaleSubject;
    }

    public static final /* synthetic */ AtomicInteger access$getPureEvilEasterEggCounter$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.pureEvilEasterEggCounter;
    }

    public static final /* synthetic */ BehaviorSubject access$getPureEvilEasterEggSubject$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.getPureEvilEasterEggSubject();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance) {
        return widgetSettingsAppearance.toastManager;
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetSettingsAppearance widgetSettingsAppearance, ToastManager toastManager) {
        widgetSettingsAppearance.toastManager = toastManager;
    }

    public static final /* synthetic */ void access$showHolyLight(WidgetSettingsAppearance widgetSettingsAppearance) {
        widgetSettingsAppearance.showHolyLight();
    }

    public static final /* synthetic */ void access$tryEnableTorchMode(WidgetSettingsAppearance widgetSettingsAppearance, boolean z2) {
        widgetSettingsAppearance.tryEnableTorchMode(z2);
    }

    public static final /* synthetic */ void access$updateTheme(WidgetSettingsAppearance widgetSettingsAppearance, String str) {
        widgetSettingsAppearance.updateTheme(str);
    }

    private final void configureFontScalingUI(int fontScale) {
        FragmentActivity activity;
        ContentResolver contentResolver;
        int systemFontScaleInt = (fontScale != -1 || (activity = getActivity()) == null || (contentResolver = activity.getContentResolver()) == null) ? fontScale : FontUtils.INSTANCE.getSystemFontScaleInt(contentResolver);
        TextView textView = getBinding().f17851d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAppearanceFontScalePlatform");
        textView.setText(getFontScaleString(systemFontScaleInt, fontScale == -1));
        SeekBar seekBar = getBinding().f17853f;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setProgress(systemFontScaleInt - 80);
    }

    private final void configureThemeOption(CheckedSetting checkedSetting, String str) {
        checkedSetting.setOnCheckedListener(new C96271(str));
    }

    private final void configureUI(Model model) {
        boolean z2 = !Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_LIGHT);
        getBinding().f17859l.m8529g(!z2, false);
        CheckedSetting checkedSetting = getBinding().f17859l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceThemeLightRadio");
        configureThemeOption(checkedSetting, ModelUserSettings.THEME_LIGHT);
        getBinding().f17859l.m8527e(new ViewOnClickListenerC96281());
        getBinding().f17857j.m8529g(z2, false);
        CheckedSetting checkedSetting2 = getBinding().f17857j;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsAppearanceThemeDarkRadio");
        configureThemeOption(checkedSetting2, ModelUserSettings.THEME_DARK);
        getBinding().f17857j.m8527e(new ViewOnClickListenerC96292(model));
        if (Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL)) {
            CheckedSetting.m8523d(getBinding().f17860m, null, 1);
        }
        getBinding().f17860m.m8529g(Intrinsics3.areEqual(model.getCurrentTheme(), ModelUserSettings.THEME_PURE_EVIL), false);
        CheckedSetting checkedSetting3 = getBinding().f17860m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsAppearanceThemePureEvilSwitch");
        checkedSetting3.setVisibility(model.getCanSeePureEvil() ? 0 : 8);
        getBinding().f17860m.setOnCheckedListener(new C96303(model));
        configureFontScalingUI(model.getFontScale());
        getBinding().f17853f.setOnSeekBarChangeListener(new C96314());
        getBinding().f17852e.setOnClickListener(ViewOnClickListenerC96325.INSTANCE);
        setupMessage(model);
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f17858k, getBinding().f17855h, getBinding().f17850c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }

    private final WidgetSettingsAppearanceBinding getBinding() {
        return (WidgetSettingsAppearanceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFontScaleString(int fontScale, boolean useSystemFontScale) {
        if (useSystemFontScale) {
            return fontScale + "% (" + getString(C5419R.string.accessibility_font_scaling_use_os) + ')';
        }
        return fontScale + "% (" + getString(C5419R.string.accessibility_font_scaling_use_app) + ')';
    }

    public static /* synthetic */ String getFontScaleString$default(WidgetSettingsAppearance widgetSettingsAppearance, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return widgetSettingsAppearance.getFontScaleString(i, z2);
    }

    private final BehaviorSubject<Boolean> getPureEvilEasterEggSubject() {
        return (BehaviorSubject) this.pureEvilEasterEggSubject.getValue();
    }

    private final void setupMessage(Model model) {
        SimpleDraweeView simpleDraweeView = getBinding().f17849b.f16319c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatItem.chatListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, model.getMeUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
        TextView textView = getBinding().f17849b.f16322f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatItem.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f17849b.f16320d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatItem.chatListAdapterItemTextName");
        textView2.setText(model.getMeUser().getUsername());
        TextView textView3 = getBinding().f17849b.f16323g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatItem.chatListAdapterItemTextTimestamp");
        textView3.setText(TimeUtils.toReadableTimeString$default(requireContext(), ClockFactory.get().currentTimeMillis(), null, 4, null));
        LinkifiedTextView linkifiedTextView = getBinding().f17849b.f16318b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.chatItem.chatListAdapterItemText");
        linkifiedTextView.setText(getString(C5419R.string.user_settings_appearance_preview_message_1));
    }

    private final void showHolyLight() {
        AppToast.m166d(getContext(), C5419R.string.theme_holy_light_reveal, 0, this.toastManager);
        tryEnableTorchMode(true);
        View view = getBinding().f17854g;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
        view.setVisibility(0);
        Observable<Long> observableM11068d0 = Observable.m11068d0(3L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .timer(3, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96361(), 62, (Object) null);
    }

    private final void tryEnableTorchMode(boolean enabled) {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = getContext();
            CameraManager cameraManager = (CameraManager) (context != null ? context.getSystemService(ChatInputComponentTypes.CAMERA) : null);
            if (cameraManager != null) {
                try {
                    String[] cameraIdList = cameraManager.getCameraIdList();
                    if (cameraIdList == null || (str = cameraIdList[0]) == null) {
                        return;
                    }
                    cameraManager.setTorchMode(str, enabled);
                } catch (Exception e) {
                    AppLog.f14950g.mo8370w("Unable to turn on flashlight", e);
                }
            }
        }
    }

    private final void updateTheme(String theme) {
        StoreStream.INSTANCE.getUserSettingsSystem().setTheme(theme, true, new C96371(theme));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.appearance);
        setActionBarSubtitle(C5419R.string.user_settings);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        SeekBar seekBar = getBinding().f17853f;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsAppearanceFontScalingSeekbar");
        seekBar.setMax(70);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> pureEvilEasterEggSubject = getPureEvilEasterEggSubject();
        Intrinsics3.checkNotNullExpressionValue(pureEvilEasterEggSubject, "pureEvilEasterEggSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(pureEvilEasterEggSubject), this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96331(this), 62, (Object) null);
        Observable<Integer> observableM11110p = this.newFontScaleSubject.m11110p(400L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11110p, "newFontScaleSubject\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), WidgetSettingsAppearance.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C96342.INSTANCE, 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().f17856i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAppearanceSyncSwitch");
        checkedSetting.setChecked(StoreStream.INSTANCE.getUserSettingsSystem().getIsThemeSyncEnabled());
        getBinding().f17856i.setOnCheckedListener(C96353.INSTANCE);
    }
}
