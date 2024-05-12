import pluginJs from '@eslint/js';
import eslintConfigPrettier from 'eslint-config-prettier';
import jest from 'eslint-plugin-jest';
import globals from 'globals';
import tseslint from 'typescript-eslint';

export default [
  { files: ['**/*.js'], languageOptions: { sourceType: 'script' } },
  { languageOptions: { globals: globals.node } },
  pluginJs.configs.recommended,
  ...tseslint.configs.recommended,
  eslintConfigPrettier,
  { ignores: ['node_modules', 'public', 'build', 'dist'] },
  {
    files: ['tests/**'],
    ...jest.configs['flat/recommended'],
    rules: {
      ...jest.configs['flat/recommended'].rules,
      'jest/prefer-expect-assertions': 'off'
    }
  }
];
