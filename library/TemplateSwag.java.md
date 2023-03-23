---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateSwag_gcd_test.java
    title: library/TemplateSwag_gcd_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSwag_test.java
    title: library/TemplateSwag_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.Pair;\n\nclass TemplateSwag<T> {\n\tint\
    \ n;\n\tT val[];\n\tSupplier<T> eSupplier;\n\tBinaryOperator<T> f;\n\n\tT front;\n\
    \tDeque<T> back = new ArrayDeque<>();\n\tint l = 0;\n\tint r = 0;\n\n\t// O(1)\n\
    \tTemplateSwag(T[] val, Supplier<T> eSupplier, BinaryOperator<T> f) {\n\t\tn =\
    \ val.length;\n\t\tthis.val = val;\n\t\tthis.eSupplier = eSupplier;\n\t\tthis.f\
    \ = f;\n\t\tfront = eSupplier.get();\n\t}\n\n\t// O(N + QlogQ)\n\t@SuppressWarnings(\"\
    unchecked\")\n\tT[] query(Pair.II[] p) {\n\t\tInteger idx[] = new Integer[p.length];\n\
    \t\tArrays.sort(idx, (ele1, ele2) -> {\n\t\t\tint c = Integer.compare(p[ele1].a,\
    \ p[ele2].a);\n\t\t\tif(c == 0) c = Integer.compare(p[ele1].b, p[ele2].b);\n\t\
    \t\tif(c == 0) c = Integer.compare(ele1, ele2);\n\t\t\treturn c;\n\t\t});\n\t\t\
    T ans[] = (T[]) new Object[p.length];\n\t\tfor(int i : idx) ans[i] = fold(p[i]);\n\
    \t\treturn ans;\n\t}\n\t// O(N + Q)\n\t// p is sorted\n\t@SuppressWarnings(\"\
    unchecked\")\n\tT[] sortedQuery(Pair.II[] p) {\n\t\tT ans[] = (T[]) new Object[p.length];\n\
    \t\tfor(int i = 0; i < p.length; i ++) ans[i] = fold(p[i]);\n\t\treturn ans;\n\
    \t}\n\n\t// return fold [i, j)\n\tT fold(Pair.II p) { return fold(p.a, p.b); }\n\
    \tT fold(int i, int j) {\n\t\tSimpleUtil.rangeCheck(i, n);\n\t\tSimpleUtil.inclusiveRangeCheck(j,\
    \ n);\n\t\tSimpleUtil.assertion(i >= l && j >= r);\n\t\twhile(r < j) front = f.apply(front,\
    \ val[r ++]);\n\t\twhile(l < i) {\n\t\t\tif(back.isEmpty()) {\n\t\t\t\tT tmp =\
    \ eSupplier.get();\n\t\t\t\tfor(int u = r - 1; u >= l; u --) {\n\t\t\t\t\ttmp\
    \ = f.apply(val[u], tmp);\n\t\t\t\t\tback.addLast(tmp);\n\t\t\t\t}\n\t\t\t\tfront\
    \ = eSupplier.get();\n\t\t\t}\n\t\t\tback.removeLast();\n\t\t\tl ++;\n\t\t}\n\t\
    \treturn back.isEmpty() ? front : f.apply(back.getLast(), front);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/Pair.java
  isVerificationFile: false
  path: library/TemplateSwag.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateSwag_gcd_test.java
  - library/TemplateSwag_test.java
documentation_of: library/TemplateSwag.java
layout: document
redirect_from:
- /library/library/TemplateSwag.java
- /library/library/TemplateSwag.java.html
title: library/TemplateSwag.java
---
