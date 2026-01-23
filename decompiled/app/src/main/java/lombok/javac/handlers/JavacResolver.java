package lombok.javac.handlers;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/JavacResolver.SCL.lombok */
public abstract class JavacResolver {
    public static final JavacResolver CLASS = new C129051("CLASS", 0);
    public static final JavacResolver METHOD = new C129062("METHOD", 1);
    public static final JavacResolver CLASS_AND_METHOD = new C129073("CLASS_AND_METHOD", 2);
    private static final /* synthetic */ JavacResolver[] ENUM$VALUES = {CLASS, METHOD, CLASS_AND_METHOD};

    public abstract Type resolveMember(JavacNode javacNode, JCTree.JCExpression jCExpression);

    public static JavacResolver[] values() {
        JavacResolver[] javacResolverArr = ENUM$VALUES;
        int length = javacResolverArr.length;
        JavacResolver[] javacResolverArr2 = new JavacResolver[length];
        System.arraycopy(javacResolverArr, 0, javacResolverArr2, 0, length);
        return javacResolverArr2;
    }

    public static JavacResolver valueOf(String str) {
        return (JavacResolver) Enum.valueOf(JavacResolver.class, str);
    }

    /* JADX INFO: renamed from: lombok.javac.handlers.JavacResolver$1 */
    /* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/JavacResolver$1.SCL.lombok */
    enum C129051 extends JavacResolver {
        C129051(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.javac.handlers.JavacResolver
        public Type resolveMember(JavacNode node, JCTree.JCExpression expr) {
            Type type = expr.type;
            if (type == null) {
                try {
                    new JavacResolution(node.getContext()).resolveClassMember(node);
                    type = expr.type;
                } catch (Exception unused) {
                }
            }
            return type;
        }
    }

    private JavacResolver(String str, int i) {
    }

    /* synthetic */ JavacResolver(String str, int i, JavacResolver javacResolver) {
        this(str, i);
    }

    /* JADX INFO: renamed from: lombok.javac.handlers.JavacResolver$2 */
    /* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/JavacResolver$2.SCL.lombok */
    enum C129062 extends JavacResolver {
        C129062(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.javac.handlers.JavacResolver
        public Type resolveMember(JavacNode node, JCTree.JCExpression expr) {
            Type type = expr.type;
            if (type == null) {
                try {
                    JCTree.JCExpression resolvedExpression = new JavacResolution(node.getContext()).resolveMethodMember(node).get(expr);
                    if (resolvedExpression != null) {
                        type = resolvedExpression.type;
                    }
                } catch (Exception unused) {
                }
            }
            return type;
        }
    }

    /* JADX INFO: renamed from: lombok.javac.handlers.JavacResolver$3 */
    /* JADX INFO: loaded from: discord-126021.apk:lombok/javac/handlers/JavacResolver$3.SCL.lombok */
    enum C129073 extends JavacResolver {
        C129073(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.javac.handlers.JavacResolver
        public Type resolveMember(JavacNode node, JCTree.JCExpression expr) {
            JavacNode classNode;
            Type type = METHOD.resolveMember(node, expr);
            if (type == null) {
                JavacNode javacNodeUp = node;
                while (true) {
                    classNode = javacNodeUp;
                    if (classNode == null || !noneOf(classNode.get(), JCTree.JCBlock.class, JCTree.JCMethodDecl.class, JCTree.JCVariableDecl.class)) {
                        break;
                    }
                    javacNodeUp = classNode.m10925up();
                }
                if (classNode != null) {
                    type = CLASS.resolveMember(classNode, expr);
                }
            }
            return type;
        }

        private boolean noneOf(Object o, Class<?>... clsArr) {
            for (Class<?> clazz : clsArr) {
                if (clazz.isInstance(o)) {
                    return false;
                }
            }
            return true;
        }
    }
}
