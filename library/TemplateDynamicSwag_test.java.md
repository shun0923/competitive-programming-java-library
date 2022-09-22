---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSwag.java
    title: library/TemplateDynamicSwag.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/queue_operate_all_composite
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateDynamicSwag_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/queue_operate_all_composite\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Pair;\nimport library.Mod;\n\
    import library.TemplateDynamicSwag;\n\npublic class TemplateDynamicSwag_test extends\
    \ Solver {\n\tpublic static void main(final String[] args) { main(args, new TemplateDynamicSwag_test());\
    \ }\n\n\tpublic void solve() {\n\t\tMod md = Mod998.md;\n\t\tint q = ni();\n\t\
    \tTemplateDynamicSwag<Pair.LL> swag = new TemplateDynamicSwag<>(\n\t\t\t() ->\
    \ new Pair.LL(1, 0),\n\t\t\t(ele1, ele2) -> new Pair.LL(md.mul(ele1.a, ele2.a),\
    \ md.mod(ele2.a * ele1.b + ele2.b)));\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\
    \tswitch(ni()) {\n\t\t\tcase 0: swag.push(Pair.npll()); break;\n\t\t\tcase 1:\
    \ swag.pop(); break;\n\t\t\tcase 2: Pair.LL p = swag.fold(); prtln(md.mod(p.a\
    \ * nl() + p.b)); break;\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Pair.java
  - library/Mod.java
  - library/TemplateDynamicSwag.java
  isVerificationFile: true
  path: library/TemplateDynamicSwag_test.java
  requiredBy: []
  timestamp: '2022-09-22 13:28:40+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateDynamicSwag_test.java
layout: document
redirect_from:
- /verify/library/TemplateDynamicSwag_test.java
- /verify/library/TemplateDynamicSwag_test.java.html
title: library/TemplateDynamicSwag_test.java
---
